package com.example.springbook.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer bookCount;
    private String publishingHome;
    private BigDecimal price;
    private Integer status; //0-已删除 1-可借阅 2-不可借阅
    private String statusCN;
    private String coverPicture;
    private String description;
}
