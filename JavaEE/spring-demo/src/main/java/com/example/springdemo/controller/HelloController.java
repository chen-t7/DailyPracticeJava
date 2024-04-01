package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String Hello() {
        return "hello SpringBoot";
    }
}
