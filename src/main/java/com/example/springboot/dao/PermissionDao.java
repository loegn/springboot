package com.example.springboot.dao;

import com.example.springboot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date : 2018/10/23 15:21
 * @author: liangenmao
 * @description:
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission, Integer> {
}
