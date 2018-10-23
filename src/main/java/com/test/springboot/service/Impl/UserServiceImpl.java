package com.test.springboot.service.Impl;

import com.test.springboot.dao.UserRepository;
import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public Boolean updateById(User user) {
        return true;
    }
}
