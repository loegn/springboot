package com.test.springboot.config;

import com.test.springboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2018/10/23 13:16
 * @author: liangenmao
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        List<String> strings = new ArrayList<>();
        strings.add("/login");
        strings.add("/interceptor/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns(strings).excludePathPatterns("/interceptor/exclude");
    }
}
