package com.acg.community.controller;

import com.acg.community.entity.DiscussPost;
import com.acg.community.entity.PageParams;
import com.acg.community.entity.User;
import com.acg.community.service.DiscussPostService;
import com.acg.community.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    DiscussPostService discussPostService;

    @Autowired
    UserService userService;

    /**
     * 首页
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize,
                               Model model) {
        //使用PageHelper插件查询首页
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(discussPostService.findAllDiscussPosts());
        model.addAttribute("pageInfo",pageInfo);


//        System.out.println(list.size()); 10
        List<DiscussPost> list = pageInfo.getList();
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        //把发帖子的用户名添进来
        if (list != null && list.size() != 0) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPost", discussPosts);

        return "index";
    }

}
