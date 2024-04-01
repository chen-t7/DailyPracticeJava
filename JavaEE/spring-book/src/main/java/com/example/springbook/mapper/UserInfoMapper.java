package com.example.springbook.mapper;

import com.example.springbook.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name = #{userName}")
    UserInfo selectByUserName(String userName);

    @Insert("insert into user_info (user_name, password) values (#{userName}, #{password})")
    Integer insertUserInfo(@Param("userName")String userName, @Param("password") String password);
}
