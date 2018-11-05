package com.test.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date : 2018/11/01 14:32
 * @author: liangenmao
 */
@ControllerAdvice
public class MyServletErrorController {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception e) {
        e.printStackTrace();
        return e;
    }
}
