package com.example.springdemo.service;

import com.example.springdemo.mapper.MessageMapper;
import com.example.springdemo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public void addMessage(MessageInfo messageInfo) {
        messageMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> selectAllMessage() {
        return messageMapper.selectAll();
    }
}
