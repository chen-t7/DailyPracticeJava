package com.blog.community.controller;

import com.blog.community.model.DiscussPost;
import com.blog.community.model.Page;
import com.blog.community.model.User;
import com.blog.community.service.DiscussPostService;
import com.blog.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        List<DiscussPost> list = discussPostService.selectDiscussByPage(1, 0, 10);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list == null) {
            return "error";
        }
        for (DiscussPost post: list) {
            Map<String, Object> map = new HashMap<>();
            map.put("post", post);
            User user = (User)userService.selectUserById(post.getUserId());
            map.put("user", user);
            discussPosts.add(map);
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
