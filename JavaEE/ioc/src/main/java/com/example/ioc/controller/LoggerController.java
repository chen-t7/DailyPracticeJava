package com.example.ioc.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
public class LoggerController {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @PostConstruct
    public void print() {
        System.out.println("打印日志");
        log.info("======我是日志框架打印的日志======");
        log.error("我是error日志");
        log.warn("我是warn");
        log.info("我是info");
        log.debug("我是debug");
        log.trace("我是trace");
    }
}
