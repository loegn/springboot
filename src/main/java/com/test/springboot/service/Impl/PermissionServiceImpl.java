package com.test.springboot.service.Impl;

import com.test.springboot.entity.Permission;
import com.test.springboot.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date : 2018/10/19 15:43
 * @author: liangenmao
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getByRoleId(Integer roleId) {
        return null;
    }
}
