package com.example.springbook.service;

import com.example.springbook.enums.BookStatusEnum;
import com.example.springbook.mapper.BookInfoMapper;
import com.example.springbook.model.BookInfo;
import com.example.springbook.model.PageRequst;
import com.example.springbook.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public PageResult<BookInfo> getBookListPage(PageRequst pageRequst) {
        if (pageRequst == null) {
            return null;
        }
        Integer result = bookInfoMapper.count();
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoByLimit(pageRequst.getOffset(), pageRequst.getPageSize());
        if (bookInfos == null || result <= 0) {
            return null;
        }
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatusEnum.getStatusCNByCode(bookInfo.getStatus()).getStatusCN());
        }
        return new PageResult<>(bookInfos, result, pageRequst);
    }

    public Integer addBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.insertBookInfo(bookInfo);
        } catch (Exception e) {
            log.error("添加图书失败，e:{}", e);
        }
        return result;
    }

    public Integer updateBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.updateBookInfo(bookInfo);
        } catch (Exception e) {
            log.error("更新图书失败， e:{}", e);
        }
        return result;
    }

    public BookInfo queryBookInfoById(Integer bookId) {
        BookInfo bookInfo = bookInfoMapper.queryBookInfoById(bookId);
        if (bookInfo != null) {
            bookInfo.setStatusCN(BookStatusEnum.getStatusCNByCode(bookInfo.getStatus()).getStatusCN());
        }
        return bookInfo;
    }

    public Integer batchDelete(List<Integer> ids) {
        Integer result = null;
        try {
            result = bookInfoMapper.batchDelete(ids);
        } catch (Exception e) {
            log.error("删除数据库失败, e:{}", e);
        }
        return result;
    }
}
