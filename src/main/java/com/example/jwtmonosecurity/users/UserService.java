package com.example.jwtmonosecurity.users;

import com.example.jwtmonosecurity.users.AppUser;
import com.example.jwtmonosecurity.roles.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUserById(String username);

    List<AppUser> getUsers();
}