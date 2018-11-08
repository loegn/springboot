package com.example.springboot.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = "permissionList")
public class Role implements Serializable {
    private static final long serialVersionUID = 3896274833971959510L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private Date createDate;
    private Date lastModifyDate;
    @Column(unique = true, nullable = false)
    private String roleName;
    private Boolean isEnable;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private List<Permission> permissionList;
}