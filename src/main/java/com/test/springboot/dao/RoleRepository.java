package com.test.springboot.dao;

import com.test.springboot.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date : 2018/10/23 15:20
 * @author: liangenmao
 * @description:
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
