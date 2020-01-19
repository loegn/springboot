package com.example.springboot.controller;

import com.example.springboot.dao.EnumTestMapper;
import com.example.springboot.entity.EnumTest;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.type.EnumTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date : 2020/01/18
 * @author: liangenmao
 */
@RestController
public class MySQLController {
    @Autowired
    private EnumTestMapper enumTestMapper;

    @ApiOperation("测试下MySQL优化")
    @GetMapping("/anon/mysql/optimize")
    public Object optimize(){
        EnumTest enumTest = enumTestMapper.selectById(1);
        return enumTest;
    }
}
