package com.example.jwtmonosecurity.roles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleToUserForm {
    private String username;
    private String roleName;
}