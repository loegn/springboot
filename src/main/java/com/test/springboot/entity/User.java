package com.test.springboot.entity;

import lombok.Data;
import lombok.ToString;
//import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = "roleList")
@Table(indexes = {@Index(columnList = "is_delete")})
//@Where(clause = "is_delete = 1")
public class User implements Serializable {
    private static final long serialVersionUID = -921750836981071896L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private Date createDate;
    private Date lastModifyDate;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String lastLoginIp;
    private Date lastLoginDate;
    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roleList;
}