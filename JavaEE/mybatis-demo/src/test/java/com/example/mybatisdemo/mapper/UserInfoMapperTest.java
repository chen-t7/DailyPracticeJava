package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectAll() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        log.info(userInfoList.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll2();
        log.info(userInfoList.toString());
    }

    @Test
    void selectAll3() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll3();
        log.info(userInfoList.toString());
    }

    @Test
    void selectOne() {
        UserInfo userInfo = userInfoMapper.selectOne(7);
        log.info(userInfo.toString());
    }

    @Test
    void selectOne2() {
        log.info(userInfoMapper.selectOne2(2).toString());
    }

    @Test
    void selectByName() {
        List<UserInfo> userInfoList = userInfoMapper.selectByName("' or 1 = '1");
        log.info(userInfoList.toString());
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(1);
        userInfo.setGender(1);
        userInfo.setPhone("15200000004");
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 方法, 执行结果: {}, 自增id:{}",result, userInfo.getId());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(1);
        userInfo.setGender(1);
        userInfo.setPhone("15200000004");
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123");

        Integer result = userInfoMapper.insert2(userInfo);
        log.info("insert 方法, 执行结果: {}, 自增id:{}",result, userInfo.getId());
    }

    @Test
    void delete() {
        Integer result = userInfoMapper.delete(6);
        log.info("删除id={}的数据", result);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(8);
        userInfo.setId(7);
        Integer result = userInfoMapper.update(userInfo);
        if (result > 0) {
            log.info("数据修改成功");
        }
    }

    @Test
    void selectUserBySort() {
        log.info(userInfoMapper.selectUserBySort("desc").toString());
    }

    @Test
    void selectUserByLike() {
        log.info(userInfoMapper.selectUserByLike("java").toString());
    }
}