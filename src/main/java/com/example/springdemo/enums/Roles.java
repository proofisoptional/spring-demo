package com.example.springdemo.enums;

import lombok.Getter;

@Getter
public enum Roles {
    ADMIN ("admin"),
    MANAGER ("manager"),
    DEVELOPER ("dev"),
    CUSTOMER ("cutomer");


    private String role_name;

    Roles(String role_name) {
        this.role_name = role_name;
    }

    public static Roles getRoleByValue(String role_name) {
        for (Roles role : Roles.values()) {
            if (role.getRole_name().equals(role_name)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role name: " + role_name);
    }
}
