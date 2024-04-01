package com.example.ioc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping("/test")
@Controller
@ResponseBody
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "测试controller和其他注解的区别";
    }
}
