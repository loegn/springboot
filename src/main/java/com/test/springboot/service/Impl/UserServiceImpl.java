package com.test.springboot.service.Impl;

import com.test.springboot.dao.UserDao;
import com.test.springboot.pojo.User;
import com.test.springboot.service.UserService;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userDao.findByUsernameAndIsDelete(username,false);
    }

    @Override
    @Transactional
    public Boolean updateById(User user) {
        try{
            userDao.save(user);
        }catch (StaleObjectStateException e){
            return false;
        }
        return true;
    }

    @Override
    public User addUser(User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setCreateDate(new Date());
        user1.setLastModifyDate(new Date());
        return userDao.save(user1);
    }
}
