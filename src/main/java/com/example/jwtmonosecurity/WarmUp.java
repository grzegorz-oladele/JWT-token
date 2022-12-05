package com.example.jwtmonosecurity;

import com.example.jwtmonosecurity.domain.AppUser;
import com.example.jwtmonosecurity.domain.Role;
import com.example.jwtmonosecurity.repository.RoleRepository;
import com.example.jwtmonosecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptySet;

@Component
@RequiredArgsConstructor
public class WarmUp implements CommandLineRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) {
        if (roleRepository.findAll().isEmpty()) {
            Role admin = Role.builder().withAuthority("ROLE_ADMIN").build();
            roleRepository.save(admin);
            Role user = Role.builder().withAuthority("ROLE_USER").build();
            roleRepository.save(user);
        }

        if (userService.getUsers().isEmpty()) {
            AppUser user = AppUser.builder()
                    .withName("Grzegorz")
                    .withUsername("grzesiek136")
                    .withPassword("password")
                    .withAuthorities(emptySet())
                    .build();
            userService.saveUser(user);
            if (user.getAuthorities().isEmpty()) {
                userService.addRoleToUser(user.getUsername(), "ROLE_ADMIN");
                userService.addRoleToUser(user.getUsername(), "ROLE_USER");
            }
        }
    }
}