package com.basico.gonzalo.basicogonzalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basico.gonzalo.basicogonzalo.model.UserProfile;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}
