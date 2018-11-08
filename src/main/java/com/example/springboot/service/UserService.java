package com.example.springboot.service;

import com.example.springboot.entity.User;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 * @description:
 */
public interface UserService {
    User getByUsername(String username);
    Boolean updateById(User user);
    User addUser(User user);
}
