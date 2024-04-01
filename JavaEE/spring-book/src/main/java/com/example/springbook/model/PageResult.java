package com.example.springbook.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T>{
    /*
    当前页记录
     */
    private List<T> records;
    private Integer total;
    private PageRequst pageRequst;
    public PageResult(List<T> records, Integer total, PageRequst pageRequst) {
        this.pageRequst = pageRequst;
        this.records = records;
        this.total = total;
    }
}
