package com.example.springdemo.controller;

import com.example.springdemo.model.MessageInfo;
import com.example.springdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
//    private List<MessageInfo> messageInfoList = new ArrayList<>();
    @Autowired
    private MessageService messageService;

    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo) {
        //进行参数的校验
        if (!StringUtils.hasLength(messageInfo.getMessage())
            ||!StringUtils.hasLength(messageInfo.getTo())
            ||!StringUtils.hasLength(messageInfo.getFrom())) {
            return false;
        }
//        添加留言
//        messageInfoList.add(messageInfo);
        messageService.addMessage(messageInfo);
        return true;
    }

    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo() {
//        return messageInfoList;
        return messageService.selectAllMessage();
    }
}
