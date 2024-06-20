package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.UserProfileDTO;
import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.model.entity.UserType;

public class UserProfileMapper {

    public static UserProfileDTO toUserProfileDTO(UserProfile userProfile) {
        if (userProfile == null) {
            return null;
        }
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setId(userProfile.getId());
        userProfileDTO.setFirstName(userProfile.getFirstName());
        userProfileDTO.setLastName(userProfile.getLastName());
        userProfileDTO.setAge(userProfile.getAge());
        userProfileDTO.setUserTypeId(userProfile.getUserType().getUser_types_id());
        userProfileDTO.setCountry(userProfile.getCountry());
        userProfileDTO.setPhoneNumber(userProfile.getPhoneNumber());
        userProfileDTO.setPassword(userProfile.getPassword());
        userProfileDTO.setUsername(userProfile.getUsername());

        return userProfileDTO;
    }

    public static UserProfile toEntity(UserProfileDTO userProfileDTO, UserType userType) {
        if (userProfileDTO == null) {
            return null;
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setId(userProfileDTO.getId());
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setUsername(userProfileDTO.getUsername());
        userProfile.setAge(userProfileDTO.getAge());
        userProfile.setPassword(userProfileDTO.getPassword());
        userProfile.setPhoneNumber(userProfileDTO.getPhoneNumber());
        userProfile.setCountry(userProfileDTO.getCountry());
        userProfile.setUserType(userType);
        userProfile.setIsActive(userProfileDTO.getIsActive());

        return userProfile;
    }
}

