package com.blog.community.service;

import com.blog.community.mapper.DiscussPostMapper;
import com.blog.community.model.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> selectDiscussByPage(Integer userId, Integer offset, Integer limit){
        return discussPostMapper.selectDiscussByPage(userId, offset, limit);
    }

    public Integer selectDiscussPostRows(Integer userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
