package com.test.springboot.service;

import com.test.springboot.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @date : 2018/10/17 15:58
 * @author: liangenmao
 * @description:
 */
public interface UserService {
    User getById(long id);
}
