package com.example.ioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {
    //Primary-标识默认的对象
//    @Primary
    @Bean("user1")
    public UserInfo userInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setId(1);
        userInfo.setName("zhangsan");
        return userInfo;
    }

    @Bean({"user2", "uu2"})
    public UserInfo userInfo2(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setId(2);
        userInfo.setName("lisi");
        return userInfo;
    }

    @Bean
    public String name() {
        return "wangwu";
    }

    @Bean
    public String name2() {
        return "lisi";
    }

    @Bean
    public UserInfo userInfo3(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setId(2);
        userInfo.setName(name);
        return userInfo;
    }
}
