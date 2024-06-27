package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.UserProfileDTO;
import com.example.filmreviewapplication.mapper.UserProfileMapper;
import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.model.entity.UserType;
import com.example.filmreviewapplication.repository.UserRepository;
import com.example.filmreviewapplication.repository.UserTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@SQLRestriction("is_active = true")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserTypeRepository userTypeRepository;

    public UserProfileDTO createUser(UserProfileDTO userProfileDTO) {

        UserType userType = userTypeRepository.findById(userProfileDTO.getUserTypeId())
                .orElseThrow(() -> new RuntimeException("UserType not found"));
        UserProfile userProfile = UserProfileMapper.toEntity(userProfileDTO, userType);
        UserProfile savedUserProfile = userRepository.save(userProfile);
        return UserProfileMapper.toUserProfileDTO(savedUserProfile);
    }

    public UserProfileDTO getUserProfileById(Long id) {

        UserProfile userProfile = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserProfileMapper.toUserProfileDTO(userProfile);
    }

    public UserProfileDTO getUserProfileByUsername(String username) {

        UserProfile userProfile = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserProfileMapper.toUserProfileDTO(userProfile);
    }

    public UserProfileDTO getUserProfileByPhoneNumber(String phoneNumber) {
        UserProfile userProfile = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserProfileMapper.toUserProfileDTO(userProfile);
    }

    public void deleteUserById(Long id) {
        var userProfile = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userProfile.setIsActive(false);
        userRepository.save(userProfile);
    }

    public UserProfile updateUser(Long id, UserProfileDTO updatedUserProfileDTO) {

        return userRepository.findById(id).map(existingUser -> {

                    existingUser.setFirstName(updatedUserProfileDTO.getFirstName());
                    existingUser.setLastName(updatedUserProfileDTO.getLastName());
                    existingUser.setPhoneNumber(updatedUserProfileDTO.getPhoneNumber());
                    existingUser.setPassword(updatedUserProfileDTO.getPassword());
                    existingUser.setCountry(updatedUserProfileDTO.getCountry());
                    existingUser.setAge(updatedUserProfileDTO.getAge());
                    existingUser.setUsername(updatedUserProfileDTO.getUsername());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
