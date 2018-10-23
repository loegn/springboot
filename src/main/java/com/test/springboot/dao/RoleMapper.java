package com.test.springboot.dao;

import com.test.springboot.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}