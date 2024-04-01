package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {
    @Select("select * from articleinfo where id = #{articleId}")
    ArticleInfo selectById(Integer articleId);

//    多表查詢
    @Select("select ta.*, tb.username, tb.age from articleinfo ta left join userinfo tb " +
            "on ta.uid = tb.id where ta.id = #{articleId}")
    ArticleInfo selectArticleAndUserById(Integer articleId);
}
