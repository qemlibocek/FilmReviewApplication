package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;

    public UserProfile createUser(UserProfile userProfile) {

        var newUserProfile = userRepository.save(userProfile);
        return newUserProfile;

    }

    public UserProfile getUserProfileById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfile getUserProfileByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfile getUserProfileByPhoneNumber(String phoneNumber) {

        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(Long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
