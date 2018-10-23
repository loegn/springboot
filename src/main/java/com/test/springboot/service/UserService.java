package com.test.springboot.service;

import com.test.springboot.entity.User;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 * @description:
 */
public interface UserService {
    User getByUsername(String username);
    Boolean updateById(User user);
}
