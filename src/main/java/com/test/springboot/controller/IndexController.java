package com.test.springboot.controller;

import com.test.springboot.utils.PropertiesUtils;
import com.test.springboot.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
@RestController
public class IndexController {
    public static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        request.getParameter("");
        BeanUtils.getBean(PropertiesUtils.class).getLoggerFile();
        BeanUtils.getBean(PropertiesUtils.class).getRoot();
        BeanUtils.getBean(PropertiesUtils.class).getArray();
        return "index";
    }
}
