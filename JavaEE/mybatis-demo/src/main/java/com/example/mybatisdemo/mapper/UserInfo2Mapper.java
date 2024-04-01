package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfo2Mapper {
    @Insert("<script>" +
            "insert into userinfo (username, password, age, " +
            "<if test='gender!=null'>gender,</if>" +
            "phone)" +
            " values (#{username}, #{password}, #{age}, " +
            "<if test='gender!=null'>#{gender},</if>" +
            "#{phone})" +
            "</script>")
    Integer insert(UserInfo userInfo);

    Integer insertXML(UserInfo userInfo);

    /**
     * 使用where标签:如果查询条件都为空，where标签会自动去除where关键字，trim不会
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition(UserInfo userInfo);

    /**
     * 使用trim标签:如果查询条件都为空，where标签会自动去除where关键字，trim不会
     * 解决办法，在wher后面加1=1，这个表达式无论如何都是true
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition2(UserInfo userInfo);

    /**
     * 使用注解的方式
     * @param userInfo
     * @return
     */
    @Select("<script>" +
            "select * from userinfo\n" +
            "        <where>" +
            "            <if test='username!=null'>" +
            "                username = #{username}" +
            "            </if>" +
            "            <if test=\"password!=null\">" +
            "                and password = #{password}" +
            "            </if>" +
            "            <if test=\"age!=null\">" +
            "                and age = #{age}" +
            "            </if>" +
            "            <if test=\"gender!=null\">" +
            "                and gender = #{gender}" +
            "            </if>" +
            "        </where>" +
            "</script>")
    List<UserInfo> selectByCondition3(UserInfo userInfo);

    /**
     * 使用trim标签
     * @param userInfo
     * @return
     */
    Integer updateByCondition(UserInfo userInfo);

    /**
     * 使用set标签
     * @param userInfo
     * @return
     */
    Integer updateByCondition2(UserInfo userInfo);

    /**
     * 通过id批量删除
     * @param ids
     * @return
     */
    Integer batchDelete(List<Integer> ids);
}
