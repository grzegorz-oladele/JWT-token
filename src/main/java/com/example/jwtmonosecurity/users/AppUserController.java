package com.example.jwtmonosecurity.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    @GetMapping("/user-message")
    ResponseEntity<String> getMessageForUser() {
        return ok("Message for user");
    }

    @GetMapping("/admin-message")
    ResponseEntity<String> getMessageForSuperUser() {
        return ok("Message for super admin");
    }

    @GetMapping("/permit-all-message")
    ResponseEntity<String> getMessageForAll() {
        return ok("Message for all");
    }

    @GetMapping("/user-admin-message")
    ResponseEntity<String> getMessageForUserAndAdmin() {
        return ok("Message for user and admin");
    }

    @GetMapping("/authenticated-message")
    ResponseEntity<String> getMessageForAuthenticatedUsers() {
        return ok("Message for authenticated users");
    }
}