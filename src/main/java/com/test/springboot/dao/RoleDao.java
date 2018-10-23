package com.test.springboot.dao;

import com.test.springboot.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date : 2018/10/23 15:20
 * @author: liangenmao
 * @description:
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
//    @Query("select r from Role r where r.id in (select ur.role_id from UserRole ur where ur.user_id = ?1)")
//    List<Role> findByUserId(Integer userId);
}
