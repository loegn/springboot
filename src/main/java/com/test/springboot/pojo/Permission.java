package com.test.springboot.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version;
    private Date createDate;
    private Date lastModifyDate;
    @Column(unique = true, nullable = false)
    private String permissionName;
    @Column(unique = true, nullable = false)
    private String permissionUrl;
    private Boolean isEnable;
}