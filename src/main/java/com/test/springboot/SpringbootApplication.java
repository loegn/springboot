package com.test.springboot;

import com.test.springboot.config.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

//import org.mybatis.spring.annotation.MapperScan;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@ServletComponentScan(value = {CommonConstants.FILTER_SCAN, CommonConstants.LISTENER_SCAN})
//@MapperScan(CommonConstants.MAPPERSCAN)
public class SpringbootApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringbootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        System.out.println("started");
    }
}
