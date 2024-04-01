package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {
    List<UserInfo> selectAll();
    List<UserInfo> selectAll2();
    List<UserInfo> selectAll3();

    Integer insert(UserInfo userInfo);

    Integer insert2(@Param("userInfo")UserInfo userInfo);

    Integer delete(Integer id);

    Integer update(UserInfo userInfo);
}
