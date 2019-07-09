package com.github.web.entity;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 17:16
 */
public class Role {

    private Integer id;

    private String roleName;

    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
