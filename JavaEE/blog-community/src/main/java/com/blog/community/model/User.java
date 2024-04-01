package com.blog.community.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private String activationCode;
    private Integer status; //'0-已激活;1-未激活'
    private Integer type; //'0-普通用户；1-管理员；2-版主'
    private String headUrl;
    private Date createTime;
}
