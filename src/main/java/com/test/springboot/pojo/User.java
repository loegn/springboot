package com.test.springboot.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private Integer version;

    private Date createDate;

    private Date lastModifyDate;

    private String username;

    private String password;

    private String lastLoginIp;

    private Date lastLoginDate;

}