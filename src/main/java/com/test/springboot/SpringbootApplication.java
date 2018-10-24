package com.test.springboot;

import com.test.springboot.config.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan(value = CommonConstants.SERVLET_COMPONENT_SCAN)
//@MapperScan(CommonConstants.MAPPERSCAN)
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        System.out.println("started");
    }
}
