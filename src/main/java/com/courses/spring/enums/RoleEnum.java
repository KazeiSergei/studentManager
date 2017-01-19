package com.courses.spring.enums;


public enum RoleEnum {
    TEACHER("TEACHER"),
    DIRECTOR("DIRECTOR");

    String roleEnum;

    RoleEnum(String roleEnum) {
        this.roleEnum = roleEnum;
    }

    public String getRoleEnum() {
        return roleEnum;
    }
}
