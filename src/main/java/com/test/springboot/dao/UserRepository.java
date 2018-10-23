package com.test.springboot.dao;

import com.test.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date : 2018/10/23 14:51
 * @author: liangenmao
 * @description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}