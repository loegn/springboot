package com.test.springboot.controller;

import com.test.springboot.service.UserService;
import com.test.springboot.utils.PropUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    public static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/index")
    public Object index(HttpServletRequest request, HttpServletResponse response){
        request.getParameter("");
        PropUtils.get("logging.level.root");
        PropUtils.get("test.array[0].host");
        PropUtils.get("test.c.a");
        return userService.getById(1);
    }
}
