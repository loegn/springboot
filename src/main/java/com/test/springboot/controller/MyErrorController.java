package com.test.springboot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date : 2018/10/24 17:41
 * @author: liangenmao
 */
@Controller
@RequestMapping
public class MyErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error.html";
    }

    @RequestMapping("/error")
    public String error() {
        return getErrorPath();
    }
}
