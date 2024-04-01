package com.example.springdemo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        //校验参数的合法性
//        if (userName == null || userName.length() == 0 || password == null || password.length() == 0) {
//            return false;
//        }
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        //进行用户名和密码的校验
        if ("admin".equals(userName) && "admin".equals(password)) {
            //设置Session
            session.setAttribute("username", "admin");
            return true;
        }
        return false;
    }
    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request) {
        //从Session中获取登录用户
        HttpSession session = request.getSession(false);
        String userName = null;
        if (session != null) {
            userName = (String)session.getAttribute("username");
        }
        return userName;
    }
}
