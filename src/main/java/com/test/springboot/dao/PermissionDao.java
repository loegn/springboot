package com.test.springboot.dao;

import com.test.springboot.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date : 2018/10/23 15:21
 * @author: liangenmao
 * @description:
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission, Integer> {
//    @Query("select p from Permission p where id = 1?")
//    List<Permission> findByRoleId(Integer roleId);
}
