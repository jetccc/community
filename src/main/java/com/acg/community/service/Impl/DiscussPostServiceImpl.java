package com.acg.community.service.Impl;

import com.acg.community.dao.DiscussPostMapper;
import com.acg.community.entity.DiscussPost;
import com.acg.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;


    @Override
    public List<DiscussPost> findAllDiscussPosts() {
        return discussPostMapper.selectAllDiscussPosts();
    }

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
