package com.example.ioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "dbtypes")
@Data
public class DBType {
//    可以采用集合或数组方式接收
//    private List<String> name;
    private String[] name;

    private HashMap<String, String> map;
}
