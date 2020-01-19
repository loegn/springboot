package com.example.springboot.enums;

import java.util.Map;

/**
 * @date : 2020/01/19
 * @author: liangenmao
 */
public enum TypeEnums {
    INSERT(0, "增加"),
    DELETE(1, "删除"),
    UPDATE(2, "修改"),
    SELECT(3, "查询");
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    TypeEnums(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private String desc;

}
