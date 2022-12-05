package com.example.jwtmonosecurity.service;

import com.example.jwtmonosecurity.domain.AppUser;
import com.example.jwtmonosecurity.domain.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUserById(String username);

    List<AppUser> getUsers();
}