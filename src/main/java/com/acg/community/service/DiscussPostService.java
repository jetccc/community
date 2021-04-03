package com.acg.community.service;

import com.acg.community.entity.DiscussPost;
import com.acg.community.entity.PageParams;

import java.util.List;

public interface DiscussPostService {
    /**
     * 查询所有帖子
     * @return
     */
    public List<DiscussPost> findAllDiscussPosts();

    /**
     * 根据id查询帖子
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);

    /**
     * 根据id查询所有的帖子
     * @param userId
     * @return
     */
    public int findDiscussPostRows(int userId);

}
