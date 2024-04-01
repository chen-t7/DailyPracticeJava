package com.example.springdemo.controller;

import com.example.springdemo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/return")
//@RestController
@Controller
public class ReturnController {
    @RequestMapping("/index")
    public String returnIndex() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData() {
        return "返回视图需要的数据";
    }

    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml() {
        return "<h1>返回html片段</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson() {
        Person person = new Person();
        person.setAge(10);
        person.setId(1);
        person.setName("zhangsan");
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMap")
    public Map<String, String> returnMap() {
        Map<String, String> kv = new HashMap<>();
        kv.put("kv1", "v1");
        kv.put("kv2", "v2");
        kv.put("kv3", "v3");
        return kv;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(401);//通常表示没有成功登陆
        return "设置状态码";
    }

    @ResponseBody
    @RequestMapping(value = "/r1", produces = "application/json;charset=utf8")
//    @RequestMapping(value = "/r1")
    public String r1(HttpServletResponse response) {
        response.setHeader("myhead", "myhead");
        return "{OK,1}";
    }

    @ResponseBody
    @RequestMapping(value = "/r2", consumes = "application/json;charset=utf8")
    public String r2(HttpServletRequest request) {
        return "{OK,1}";
    }


}
