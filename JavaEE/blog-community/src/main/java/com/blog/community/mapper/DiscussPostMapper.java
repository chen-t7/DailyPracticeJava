package com.blog.community.mapper;

import com.blog.community.model.DiscussPost;
import com.blog.community.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussByPage(@Param("userId")Integer userId,
                                          @Param("offset")Integer offset, @Param("limit")Integer limit);

    Integer selectDiscussPostRows(Integer userId);
}
