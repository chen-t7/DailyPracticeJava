package com.example.springbook.controller;

import com.example.springbook.constant.Constants;
import com.example.springbook.enums.ResultEnom;
import com.example.springbook.model.*;
import com.example.springbook.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequst pageRequst, HttpSession httpSession) {
        log.info("获取图书列表");
//        UserInfo userInfo =(UserInfo)httpSession.getAttribute(Constants.SESSION_USER_KEY);
//        if (userInfo == null || userInfo.getId() < 0 || !StringUtils.hasLength(userInfo.getUserName())) {
//            return Result.unlogin();
//        }
        if (pageRequst.getCurrentPage() < 1 || pageRequst.getPageSize() < 1) {
            return Result.fail("参数不通过");
        }
        PageResult<BookInfo> pageResult = null;
        try {
            pageResult = bookService.getBookListPage(pageRequst);
            return Result.success(pageResult);
        } catch (Exception e) {
            log.error("获取列表失败，e:{}", e);
            return Result.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/addBook", produces = "application/json")
    public Result addBook(BookInfo bookInfo) {
        log.info("接收到添加图书请求, bookInfo:{}",bookInfo);
        if (!StringUtils.hasLength(bookInfo.getBookName())
            || !StringUtils.hasLength(bookInfo.getAuthor())
            || !StringUtils.hasLength(bookInfo.getPublishingHome())
            || bookInfo.getBookCount() == null || bookInfo.getBookCount() < 0
            || bookInfo.getPrice() == null
            || bookInfo.getStatus() == null) {
            return Result.fail("参数不可校验，请检查入参");
        }
        Integer result = bookService.addBook(bookInfo);
        if (result <= 0) {
            log.error("添加图书失败 bookInfo:{}", bookInfo);
            return Result.fail("添加图书失败，请联系管理员");
        }
        return Result.success();
    }

    @RequestMapping("/updateBook")
    public Result updateBook(BookInfo bookInfo) {
        log.info("接收到更新图书请求, bookInfo:{}", bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if (result <= 0) {
            log.error("更新图书失败 bookInfo:{}, result:{}", bookInfo, result);
            return Result.fail("更新图书失败，请联系管理员");
        }
        return Result.success();
    }

    @RequestMapping("/queryBookInfoById")
    public Result queryBookInfoById(Integer bookId) {
        if (bookId == null) {
            return Result.fail("参数不合法");
        }
        BookInfo bookInfo = null;
        try {
            bookInfo = bookService.queryBookInfoById(bookId);
            return Result.success(bookInfo);
        } catch (Exception e) {
            log.error("通过id查询图书失败，e:{}", e);
            return Result.fail("通过id查询图书失败");
        }
    }

    @RequestMapping("/batchDelete")
    public Result batchDelete(@RequestParam List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return Result.fail("参数不合法");
        }
        Integer result = bookService.batchDelete(ids);
        if (result == null) {
            log.error("删除失败");
            return Result.fail("删除失败");
        }
        return Result.success();
    }
}
