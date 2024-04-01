package com.example.springbook.controller;

import com.example.springbook.constant.Constants;
import com.example.springbook.model.Result;
import com.example.springbook.model.UserInfo;
import com.example.springbook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String userName, String password, HttpSession httpSession) {
        log.info("用户进行登录");
        //判断参数是否合法
        if (!StringUtils.hasLength(userName)
            || !StringUtils.hasLength(password)) {
            return Result.fail("参数不合法");
        }
        UserInfo userInfo = userService.selectByUserName(userName);
        if (userInfo == null || userInfo.getId() <= 0) {
            return Result.fail("参数不合法");
        }
        if (userInfo.getPassword().equals(password)) {
            userInfo.setPassword("");
            httpSession.setAttribute(Constants.SESSION_USER_KEY, userInfo);
            return Result.success(true);
        }
        return Result.fail("未知原因");
    }

    @RequestMapping("/registerUser")
    public Result registerUser(String userName, String password, HttpSession httpSession) {
        log.info("注册用户");
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("请输入用户名或密码");
        }
        Integer result = userService.registerUser(userName, password);
        if (result == null || result < 0) {
            return Result.fail("用户名重复");
        }
        return Result.success("创建成功");
    }
}
