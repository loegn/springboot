package com.test.springboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    private Integer id;

    private Integer version;

    private Date createDate;

    private Date lastModifyDate;

    private String permissionName;

    private Boolean isEnable;

}