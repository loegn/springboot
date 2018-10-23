package com.test.springboot.service.Impl;

import com.test.springboot.dao.RoleDao;
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
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getByUserId(Integer userId) {
//        return roleDao.findByUserId(userId);
        return null;
    }
}
