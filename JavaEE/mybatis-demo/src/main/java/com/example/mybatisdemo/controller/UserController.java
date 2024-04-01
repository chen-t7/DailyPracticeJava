package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.mapper.UserInfoMapper;
import com.example.mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

}
