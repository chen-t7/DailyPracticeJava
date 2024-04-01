package com.example.redisdemo.bean;

import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;

@Data
public class Address {
    @Indexed
    private String country; //国家
    @Indexed
    private String city; //城市
}
