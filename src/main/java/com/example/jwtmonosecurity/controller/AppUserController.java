package com.example.jwtmonosecurity.controller;

import com.example.jwtmonosecurity.domain.AppUser;
import com.example.jwtmonosecurity.domain.Role;
import com.example.jwtmonosecurity.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {

    private final UserService userService;

    @GetMapping
    ResponseEntity<List<AppUser>> getUsers() {
        return ok(userService.getUsers());
    }

    @PostMapping("/users/save")
    ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());
        return created(uri).body(userService.saveUser(appUser));
    }

    @PostMapping("/roles/save")
    ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles/save").toUriString());
        return created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleName());
        return ok().build();
    }
}

@Getter
@Setter
class RoleToUserForm {
    private String username;
    private String roleName;
}