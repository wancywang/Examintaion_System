package com.system.model;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Role {
    private Integer roleId;

    private String roleName;

    private String rolePermissions;

    public Role(Integer roleId, String roleName, String rolePermissions) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.rolePermissions = rolePermissions;
    }

    public Role() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(String rolePermissions) {
        this.rolePermissions = rolePermissions == null ? null : rolePermissions.trim();
    }
}