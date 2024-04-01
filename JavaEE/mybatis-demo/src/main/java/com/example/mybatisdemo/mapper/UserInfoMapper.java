package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.UserInfo;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * 结果映射
     * 方法一：对结果进行映射
     * @return
     */
    @Select("select id, username, password, age, gender, phone, delete_falg as deleteFlag, " +
            "create_time as createTime, update_time " +
            "from userinfo")
    List<UserInfo> selectAll();

    /**
     * 结果映射
     * 方法二：使用注解
     * @return
     */
    @Results(id = "BaseMap", value = {
            @Result(column = "delete_flag", property = "deletaFlag"),
            @Result(column = "create+time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from userinfo")
    List<UserInfo> selectAll2();

    /**
     * 结果映射
     * 方法三：使用配置---最推荐
     * @return
     */
    @Select("select * from userinfo")
    List<UserInfo> selectAll3();

    @ResultMap(value = "BaseMap")
    @Select("select * from userinfo where username = #{username}")
    List<UserInfo> selectByName(String username);

    @ResultMap(value = "BaseMap")
    @Select("select * from userinfo where id = ${id}")
    UserInfo selectOne(Integer id);

    //对参数重命名
    @Select("select * from userinfo where id = #{userId}")
    UserInfo selectOne2(@Param("userId")Integer id);

    //设置返回自增id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into mybatis_test.userinfo (username, password, age, gender, phone)" +
            " values (#{username}, #{password}, #{age}, #{gender}, #{phone});")
    Integer insert(UserInfo userInfo);

    //对insert参数进行重命名;如果对对象进行重命名
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into mybatis_test.userinfo (username, password, age, gender, phone)" +
            " values (#{userInfo.username}, #{userInfo.password}, #{userInfo.age}, #{userInfo.gender}, #{userInfo.phone});")
    Integer insert2(@Param("userInfo")UserInfo userInfo);

    @Delete("delete from userinfo where id = #{id}")
    Integer delete(Integer id);

    @Update("update userinfo set age = #{age} where id = #{id}")
    Integer update(UserInfo userInfo);

    /**
     * 排序
     * @param sort
     * @return
     */
    @Select("select * from userinfo order by id ${sort};")
    List<UserInfo> selectUserBySort(String sort);

    /**
     * 实现模糊查询
     * @param username
     * @return
     */
    @Select("select * from userinfo where username like concat('%', '#{username}', '%')")
    List<UserInfo> selectUserByLike(String username);
}
