package com.test.springboot.service.Impl;

import com.test.springboot.dao.PermissionDao;
import com.test.springboot.pojo.Permission;
import com.test.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date : 2018/10/19 15:43
 * @author: liangenmao
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    @Autowired
    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public List<Permission> getByRoleId(Integer roleId) {
//        return permissionDao.findByRoleId(roleId);
        return null;
    }
}
