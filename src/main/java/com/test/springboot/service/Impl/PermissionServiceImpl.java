package com.test.springboot.service.Impl;

import com.test.springboot.dao.PermissionMapper;
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
    private PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> getByRoleId(Integer roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }
}
