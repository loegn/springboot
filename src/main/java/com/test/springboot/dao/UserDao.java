package com.test.springboot.dao;

import com.test.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date : 2018/10/23 14:51
 * @author: liangenmao
 * @description:
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsernameAndIsDelete(String username, Boolean isDelete);
}
