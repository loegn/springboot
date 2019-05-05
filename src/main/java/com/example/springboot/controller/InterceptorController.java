package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date : 2019/03/01 11:37
 * @author: liangenmao
 */
@RestController
public class InterceptorController {
    @RequestMapping("/interceptor")
    public Object testOne() {
        System.out.println("start");
        System.out.println("end");
        return true;
    }
}
