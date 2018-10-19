package com.test.springboot.service.Impl;

import com.test.springboot.dao.RoleMapper;
import com.test.springboot.pojo.Role;
import com.test.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date : 2018/10/19 15:43
 * @author: liangenmao
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> getByUserId(Integer userId) {
        return roleMapper.selectByUserId(userId);
    }
}
