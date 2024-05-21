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

    public UserProfile getUserProfile(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
