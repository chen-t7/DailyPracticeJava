package com.example.redisdemo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@RedisHash("person")
@Data
public class Person {
    @Id  //主键
    private String id;
    //生成二级索引，方便查询
    @Indexed
    private String firstName; //名
    @Indexed
    private String lastName; //姓
    private Address address; //家庭地址
    private List<Family> familyList; //家庭成员
}
