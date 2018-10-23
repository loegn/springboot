package com.test.springboot.service;

import com.test.springboot.pojo.Role;

import java.util.List;

/**
 * @date : 2018/10/19 15:42
 * @author: liangenmao
 * @description:
 */
public interface RoleService {
    List<Role> getByUserId(Integer userId);
}
