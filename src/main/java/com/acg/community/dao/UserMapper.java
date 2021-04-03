package com.acg.community.dao;

import com.acg.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Mapper 和 @Repository都是作用在dao层接口，使得其生成代理对象bean，交给spring 容器管理
 * 对于mybatis来说，都可以不用写mapper.xml文件
 *
 * @Mapper 不需要配置扫描地址，可以单独使用
 * @Repository 解决service层idea自动注入爆红问题，找不到bean，这是因为项目启动的时候没有去扫描使用@Repository注解的文件。
 * 所以使用@Repository需要配置扫描地址
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 根据名字查询用户
     * @param name
     * @return
     */
    User selectByName(String name);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    User selectByEmail(String email);

    /**
     * 增加一个用户
     * @param user
     * @return 返回插入数据的行数（一行）
     */
    int insertUser(User user);

    /**
     * 更新状态
     * @param id
     * @param status
     * @return  返回的修改了几行条数
     */
    int updateStatus(int id, int status);

    /**
     * 更新头像的路径
     * @param id
     * @param headerUrl
     * @return
     */
    int updateHeader(int id, String headerUrl);

    /**
     * 更新密码
     * @param id
     * @param password
     * @return
     */
    int updatePassword(int id, String password);
}
