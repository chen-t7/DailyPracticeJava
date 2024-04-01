package com.blog.community.mapper;

import com.blog.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{userName}")
    User selectByName(String userName);

    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    Integer insertUser(String userName, String password, String salt,
                       String email, String activationCode, Integer status,
                       Integer type, String headUrl);

    Integer updateUser(Integer id,String userName, String password, String salt,
                       String email, String activationCode, Integer status,
                       Integer type, String headUrl);
}
