package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectById() {
        ArticleInfo articleInfo = articleMapper.selectById(1);
        log.info(articleInfo.toString());
    }

    @Test
    void selectArticleAndUserById() {
        ArticleInfo articleInfo = articleMapper.selectArticleAndUserById(1);
        log.info(articleInfo.toString());
    }
}