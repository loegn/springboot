package com.test.springboot.dao;

import com.test.springboot.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date : 2018/10/23 15:21
 * @author: liangenmao
 * @description:
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
