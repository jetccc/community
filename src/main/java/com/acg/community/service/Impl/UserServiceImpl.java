package com.acg.community.service.Impl;

import com.acg.community.dao.UserMapper;
import com.acg.community.entity.User;
import com.acg.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

}
