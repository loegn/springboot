package com.test.springboot.service.Impl;

import com.test.springboot.pojo.Role;
import com.test.springboot.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date : 2018/10/19 15:43
 * @author: liangenmao
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Override
    public List<Role> getByUserId(Integer userId) {
        return null;
    }
}
