package com.example.ioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 从配置文件中读取某个对象，prefix = "对象前缀"
@ConfigurationProperties(prefix = "student")
@Data
public class StudentController {
    private String name;
    private Integer id;
    private Integer age;
}
