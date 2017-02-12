package com.zihua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zihua on 17-1-23.
 * Role 角色类
 * 主键为 role_id 非空
 * role_name 非空
 * <p>
 * Role 类和 User 类 为多对多关系
 * 一个角色可以被多个用户拥有
 * 一个用户可以拥有多个角色
 * <p>
 * Role 类和 Permit 为 多对多关系
 * 一个角色可以拥有多个权限
 * 一个权限可以被多个用户拥有
 */
@Entity
public class Role implements Serializable{
    private int id;
    private String name;
    private Set<User> users = new HashSet<User>();
    private Set<Permit> permits = new HashSet<Permit>();

    @Id
    @Column(name = "role_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //在 Role 和 Permit 多对多对应关系中，Role 为主控方
    //生成关联关系表 role_permit
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permit",
            joinColumns = @JoinColumn(name = "role_id"),//主控方主键
            inverseJoinColumns = @JoinColumn(name = "permit_id")//被控方主键
    )
    public Set<Permit> getPermits() {
        return permits;
    }


    public void setPermits(Set<Permit> permits) {
        this.permits = permits;
    }

    //在 User 和 Role 的多对多关系中 Role 为被控方
    //mappedBy 使用方式为 哪个被控 在哪个的类里面出现
    //mappedBy 的值为 被控方在主控声明的 集合名称
    //此例中 被控方在主控方中被声明的 集合名称为 roles
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
