package com.test.springboot.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;

    private Integer version;

    private Date createDate;

    private Date lastModifyDate;

    private String roleName;

    private Boolean isEnable;

}