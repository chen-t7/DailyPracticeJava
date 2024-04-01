package com.example.mybatisdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
//    文章相关信息
    private Integer id;
    private String title;
    private String content;
    private Integer delete_flag;
    private Date createTime;
    private Date updateTime;
//    用戶相关信息
    private String username;
    private Integer age;
}
