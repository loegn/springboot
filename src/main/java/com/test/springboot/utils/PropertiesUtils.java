package com.test.springboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test")
public class PropertiesUtils {
    @Value("${logging.file}")
    private String LoggerFile;
    @Value("${logging.level.root}")
    private String root;

    private List<Map<String,String>> array;

    public String getLoggerFile() {
        return LoggerFile;
    }

    public void setLoggerFile(String loggerFile) {
        LoggerFile = loggerFile;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<Map<String, String>> getArray() {
        return array;
    }

    public void setArray(List<Map<String, String>> array) {
        this.array = array;
    }
}
