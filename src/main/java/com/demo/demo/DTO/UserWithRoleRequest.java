package com.demo.demo.DTO;

import com.demo.demo.entities.Role;
import com.demo.demo.entities.RoleName;
import com.demo.demo.entities.UserEntity;

public class UserWithRoleRequest {
    private UserEntity user;
    private RoleName role;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
