package com.blog.community.model;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussPost {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Integer type;//0-正常；1-置顶；
    private Integer status;//0-正常；1-精华；2-拉黑'
    private Integer commentCount;
    private Double score;
    private Date createTime;
}
