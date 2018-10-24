package com.test.springboot.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = "roleList")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version;
    private Date createDate;
    private Date lastModifyDate;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String lastLoginIp;
    private Date lastLoginDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roleList;
}