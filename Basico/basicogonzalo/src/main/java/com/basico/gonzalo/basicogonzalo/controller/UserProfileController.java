package com.basico.gonzalo.basicogonzalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.basico.gonzalo.basicogonzalo.model.UserProfile;
import com.basico.gonzalo.basicogonzalo.service.UserProfileService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfile(@PathVariable UUID id) {
        System.out.println("Buscando perfil con ID: " + id);
        Optional<UserProfile> profile = service.getProfile(id);

        if (profile.isPresent()) {
            System.out.println("Perfil encontrado: " + profile.get());
            return ResponseEntity.ok(profile.get());
        } else {
            System.out.println("Perfil NO encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Perfil con ID " + id + " no encontrado.");
        }
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllProfiles() {
        List<UserProfile> profiles = service.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public UserProfile saveProfile(@RequestBody UserProfile profile) {
        return service.saveProfile(profile);
    }


    @PutMapping("/{id}")
    public UserProfile updateProfile(@PathVariable UUID id, @RequestBody UserProfile updatedProfile) {
        Optional<UserProfile> existing = service.getProfile(id);

        if (existing.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil no encontrado para actualización");
        }

        updatedProfile.setId(id);
        return service.saveProfile(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable UUID id) {
        Optional<UserProfile> profile = service.getProfile(id);
        if (profile.isPresent()) {
            service.deleteProfile(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}