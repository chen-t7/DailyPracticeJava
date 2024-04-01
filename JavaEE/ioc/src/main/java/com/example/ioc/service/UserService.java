package com.example.ioc.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//Spring默认明明规则是类名的小驼峰命名，特殊情况：类名前两个字母为大写，则BeanName就是类名
//也可自己修改名称，方式就是直接在五大注解后加("")，添加后Spring就会直接使用程序员自定义的
@Service("service")
public class UserService {
    public void doService(){
        System.out.println("doService...");
    }
}
