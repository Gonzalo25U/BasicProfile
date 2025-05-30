package com.basico.gonzalo.basicogonzalo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basico.gonzalo.basicogonzalo.model.UserProfile;
import com.basico.gonzalo.basicogonzalo.repository.UserProfileRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserProfileService {

    @Autowired
    private final UserProfileRepository repository;

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    public Optional<UserProfile> getProfile(UUID id) {
        return repository.findById(id);
    }

    public UserProfile saveProfile(UserProfile profile) {
        return repository.save(profile);
    }

    public void deleteProfile(UUID id) {
        repository.deleteById(id);
    }
    public List<UserProfile> getAllProfiles() {
    return repository.findAll();
}
}
