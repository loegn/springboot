package com.example.springboot.utils;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "example")
public class PropUtils {
    private static Environment env = BeanUtils.getBean(Environment.class);

    public static String get(String key){
        return env.getProperty(key);
    }
}
