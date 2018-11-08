package com.example.springboot.service.Impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.shiro.PasswordUtils;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findByUsernameAndIsDelete(username, false);
    }

    @Override
    public Boolean updateById(User user) {
        try {
            user.setLastModifyDate(new Date());
            userDao.save(user);
        } catch (StaleObjectStateException e) {
            return false;
        }
        return true;
    }

    @Override
    public User addUser(User user) {
        User saveUser = new User();
        saveUser.setUsername(user.getUsername());
        saveUser.setSalt(PasswordUtils.generateSalt());
        saveUser.setHashIterations(1);
        saveUser.setPassword(PasswordUtils.encryptPassword(user.getPassword(), saveUser.getSalt(), saveUser.getHashIterations()));
        saveUser.setCreateDate(new Date());
        saveUser.setLastModifyDate(new Date());
        return userDao.save(saveUser);
    }
}
