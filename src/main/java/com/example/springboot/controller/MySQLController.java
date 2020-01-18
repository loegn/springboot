package com.example.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date : 2020/01/18
 * @author: liangenmao
 */
@RestController
public class MySQLController {

    @ApiOperation("测试下MySQL优化")
    @GetMapping("/anon/mysql/optimize")
    public Object optimize(){
        return null;
    }
}
