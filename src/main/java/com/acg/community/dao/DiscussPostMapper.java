package com.acg.community.dao;

import com.acg.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {

    /**
     * 查询所有的帖子
     * @return
     */
    List<DiscussPost> selectAllDiscussPosts();

    /**
     * 查询所有帖子
     * @param userId（和我的帖子功能共用）
     * @param offset (起始行的行号)
     * @param limit  (每页多少条数据)
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 查询帖子的行数
     * @param userId (@Param注解：别名。注：如果在sql里需要动态的用到动态的条件<if>，而这个方法只有一个参数。则必须取别名。
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);

}
