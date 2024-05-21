package com.example.filmreviewapplication.repository;

import com.example.filmreviewapplication.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUsername(String username);
    Optional<UserProfile> findByPhoneNumber(String phoneNumber);
}
