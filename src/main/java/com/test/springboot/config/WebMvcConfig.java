package com.test.springboot.config;

import com.test.springboot.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date : 2018/10/23 13:16
 * @author: liangenmao
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        List<String> strings = new ArrayList<>();
        strings.add("/interceptor/**");
        registry.addInterceptor(myInterceptor()).addPathPatterns(strings).excludePathPatterns("/interceptor/exclude");
    }

    @Bean
    @Autowired
    public ConversionService getConversionService(DateConverter dateConverter) {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();

        converters.add(dateConverter);

        factoryBean.setConverters(converters);

        return factoryBean.getObject();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
