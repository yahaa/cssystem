package com.zihua.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zihua on 17-1-23.
 * Rser 类，对应数据中的 user表
 * 主键 user_id 非空
 * user_name 非空
 * password 非空
 * <p>
 * <p>
 * User 类和 Role 为 多对多关系，
 * 一个用户可以有多种角色，
 * 一个角色可以被多个用户拥有
 */
@Entity
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private Set<Role> roles = new HashSet<Role>();

    public User() {

    }

    public User(int id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
       this.password = password;
    }

    //在 User 和 Role 的多对多对应关系中，User 类为主控方
    //生成的关联关系表 user_role
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"), //主控方的 主键
            inverseJoinColumns = @JoinColumn(name = "role_id") //被控方的主键
    )
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
