package com.acg.community;

import com.acg.community.dao.DiscussPostMapper;
import com.acg.community.dao.UserMapper;
import com.acg.community.entity.DiscussPost;
import com.acg.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("aaa");
        System.out.println(user);

        user = userMapper.selectByEmail("jetchou101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("jetchou");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("jetchou@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/104.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        user = userMapper.selectByName("jetchou");
        System.out.println(row);
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/107.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "123");
        System.out.println(rows);

        User user = userMapper.selectByName("jetchou");
        System.out.println(user);
    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post : discussPosts){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }
}
