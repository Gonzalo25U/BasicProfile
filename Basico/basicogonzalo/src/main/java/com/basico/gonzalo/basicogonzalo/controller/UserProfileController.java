package com.basico.gonzalo.basicogonzalo.controller;

import org.springframework.web.bind.annotation.*;

import com.basico.gonzalo.basicogonzalo.model.UserProfile;
import com.basico.gonzalo.basicogonzalo.service.UserProfileService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<UserProfile> getProfile(@PathVariable UUID id) {
        return service.getProfile(id);
    }

    @PostMapping
    public UserProfile saveProfile(@RequestBody UserProfile profile) {
        return service.saveProfile(profile);
    }
}
