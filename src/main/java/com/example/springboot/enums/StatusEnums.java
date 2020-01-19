package com.example.springboot.enums;

/**
 * @date : 2020/01/18
 * @author: liangenmao
 */
public enum StatusEnums {
    START("开始"),
    DOING("执行"),
    END("结束");
    private String desc;

    StatusEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
