package com.example.springbook.service;

import com.example.springbook.mapper.UserInfoMapper;
import com.example.springbook.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo selectByUserName(String userName) {
        return userInfoMapper.selectByUserName(userName);
    }

    public Integer registerUser(String userName, String password){
        UserInfo userInfo = userInfoMapper.selectByUserName(userName);
        if (userInfo != null) {
            return null;
        }
        Integer result = 0;
        try {
            result = userInfoMapper.insertUserInfo(userName, password);
        } catch (Exception e) {
            log.error("创建用户失败，e:{}", e);
        }
        return result;
    }
}
