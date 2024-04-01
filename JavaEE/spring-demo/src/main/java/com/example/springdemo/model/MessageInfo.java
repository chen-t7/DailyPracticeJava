package com.example.springdemo.model;

import lombok.Data;

import java.util.Date;

@Data
//ToString
public class MessageInfo {
    //Getter Setter
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deteleFlag;
    private Date createTime;
    private Date updateTime;
}
