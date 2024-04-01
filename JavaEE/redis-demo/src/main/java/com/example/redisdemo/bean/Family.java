package com.example.redisdemo.bean;

import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;

@Data
public class Family {
    @Indexed
    private String type; //成员类型
    @Indexed
    private String name; //成员名
}
