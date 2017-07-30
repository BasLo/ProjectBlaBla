package com.company.domain.entity.role;

public enum Roles {
    USER(1, "USER"),
    ADMIN(2, "ADMIN");

    private String role;
    private int roleId;

    Roles(int roleId, String role) {
        this.role = role;
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public int getRoleId() {
        return roleId;
    }

}