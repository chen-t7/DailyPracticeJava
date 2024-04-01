package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfo2MapperTest {
    @Autowired
    private UserInfo2Mapper userInfo2Mapper;
    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("cccc");
        userInfo.setPassword("1235");
        userInfo.setPhone("123456789");
        userInfo.setAge(3);
//        userInfo.setGender(0);
        userInfo2Mapper.insert(userInfo);
    }

    @Test
    void insertXML() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("7777");
        userInfo.setPassword("1235");
//        userInfo.setPhone("123456789");
        userInfo.setAge(3);
//        userInfo.setGender(0);
        userInfo2Mapper.insertXML(userInfo);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("7777");
//        userInfo.setPassword("1235");
//        userInfo.setAge(3);
//        userInfo.setGender(0);
        List<UserInfo> userInfoList = userInfo2Mapper.selectByCondition(userInfo);
        log.info(userInfoList.toString());
    }

    @Test
    void selectByCondition2() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("7777");
//        userInfo.setPassword("1235");
//        userInfo.setAge(3);
//        userInfo.setGender(0);
        List<UserInfo> userInfoList = userInfo2Mapper.selectByCondition2(userInfo);
        log.info(userInfoList.toString());
    }

    @Test
    void selectByCondition3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("7777");
//        userInfo.setPassword("1235");
//        userInfo.setAge(3);
//        userInfo.setGender(0);
        List<UserInfo> userInfoList = userInfo2Mapper.selectByCondition3(userInfo);
        log.info(userInfoList.toString());
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("887");
//        userInfo.setPassword("1235");
//        userInfo.setAge(3);
//        userInfo.setGender(0);
        userInfo2Mapper.updateByCondition(userInfo);
    }

    @Test
    void updateByCondition2() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("4447");
//        userInfo.setPassword("1235");
//        userInfo.setAge(3);
//        userInfo.setGender(0);
        userInfo2Mapper.updateByCondition2(userInfo);
    }


    @Test
    void batchDelete() {

        userInfo2Mapper.batchDelete(Arrays.asList(25,26,27,28));
    }
}