package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Permission implements Serializable {
    private static final long serialVersionUID = 6353085922685750392L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private Date createDate;
    private Date lastModifyDate;
    @Column(unique = true, nullable = false)
    private String permissionName;
    @Column(unique = true, nullable = false)
    private String permissionUrl;
    private Boolean isEnable;
}