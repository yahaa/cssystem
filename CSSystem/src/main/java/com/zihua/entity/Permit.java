package com.zihua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zihua on 17-1-23.
 * Permit 类
 * <p>
 * permit_id 主键
 * primit_name 非空
 * <p>
 * Permit 和 Role 为多对多关系
 * Role 为主控方
 * Permit 为被控方
 */
@Entity
public class Permit implements Serializable {
    private int id;
    private String name;
    private String url;
    private Set<Role> roles = new HashSet<Role>();

    @Id
    @Column(name = "permit_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "permit_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="url",nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //声明 Permit 为被控方
    @ManyToMany(mappedBy = "permits", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
