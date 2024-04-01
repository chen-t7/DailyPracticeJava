package com.blog.community.service;

import com.blog.community.mapper.UserMapper;
import com.blog.community.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer id) {
        if (id == null) {
            return null;
        }
        User user = null;
        try{
            user = userMapper.selectById(id);
        } catch (Exception e) {
            log.info("查询用户信息失败，e:{}", e);
        }
        return user;
    }
}
