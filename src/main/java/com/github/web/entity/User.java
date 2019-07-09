package com.github.web.entity;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 17:05
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private List<Role> roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
