package com.example.springdemo.mapper;

import com.example.springdemo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("insert into message_info(`from`, `to`, `message`) " +
            "values (#{from}, #{to}, #{message})")
    void insertMessage(MessageInfo messageInfo);

    @Select("select * from message_info where delete_flag = 0")
    List<MessageInfo> selectAll();
}
