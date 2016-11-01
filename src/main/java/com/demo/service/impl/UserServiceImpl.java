package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yanlingz on 16/10/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public User findOne(int id) {
        User user=  userMapper.selectByPrimaryKey(id);
        return user;
    }


}
