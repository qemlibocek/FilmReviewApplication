package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.UserType;
import com.example.filmreviewapplication.repository.UserTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@SQLRestriction("is_active = true")
public class UserTypeService {

    UserTypeRepository userTypeRepository;

    public UserType createUserType(UserType userType) {

        return userTypeRepository.save(userType);
    }

    public List<UserType> getAllUserTypes() {

        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(Long id) {

        return userTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User type not found"));
    }

    public void deleteUserTypeById(Long id){

        UserType userTypeToDelete = userTypeRepository

                .findById(id)
                .orElseThrow(() -> new RuntimeException("User type not found"));

        userTypeToDelete.setIsActive(false);
        userTypeRepository.save(userTypeToDelete);

    }

    public UserType updateUserType (Long id, UserType userType){

        UserType userTypeToUpdate = userTypeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User type not found"));

        if (Objects.nonNull(userTypeToUpdate)){

            userTypeToUpdate.setName(userType.getName());
            userTypeRepository.save(userTypeToUpdate);

            return userTypeToUpdate;
        }

        return userTypeToUpdate;

    }
}



