package com.test.springboot.service.Impl;

import com.test.springboot.dao.UserMapper;
import com.test.springboot.pojo.User;
import com.test.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
