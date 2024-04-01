package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoXMLMapperTest {
    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void selectAll() {
        List<UserInfo> userInfoList = userInfoXMLMapper.selectAll();
        log.info(userInfoList.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> userInfoList = userInfoXMLMapper.selectAll2();
        log.info(userInfoList.toString());
    }

    @Test
    void selectAll3() {
        List<UserInfo> userInfoList = userInfoXMLMapper.selectAll2();
        log.info(userInfoList.toString());
    }
    
    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("chen");
        userInfo.setPassword("yu");
        userInfo.setAge(24);
        userInfo.setGender(0);
        userInfo.setPhone("18600000008");
        Integer result = userInfoXMLMapper.insert(userInfo);
        if (result > 0) {
            log.info("插入成功，影响行数：{}，插入结果id:{}", result, userInfo.getId());
        }
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("chen");
        userInfo.setPassword("yu");
        userInfo.setAge(24);
        userInfo.setGender(0);
        userInfo.setPhone("18600000009");
        Integer result = userInfoXMLMapper.insert2(userInfo);
        if (result > 0) {
            log.info("插入成功，影响行数：{}，插入结果id:{}", result, userInfo.getId());
        }
    }

    @Test
    void delete() {
        Integer result = userInfoXMLMapper.delete(8);
        if (result > 0) {
            log.info("删除成功，影响行数：{}", result);
        }
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setGender(3);
        userInfo.setId(9);
        Integer result = userInfoXMLMapper.update(userInfo);
        if (result > 0) {
            log.info("更新成功成功，影响行数：{}", result);
        }
    }

}