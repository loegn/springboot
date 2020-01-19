package com.example.springboot.dao;

import com.example.springboot.entity.EnumTest;
import org.springframework.stereotype.Repository;

/**
 * @date : 2020/01/18
 * @author: liangenmao
 */
@Repository
public interface EnumTestMapper {
    EnumTest selectById(Integer id);
}
