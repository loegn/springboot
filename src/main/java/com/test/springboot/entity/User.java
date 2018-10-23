package com.test.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer version;

    private Date createDate;

    private Date lastModifyDate;

    private String username;

    private String password;

    private String lastLoginIp;

    private Date lastLoginDate;

}