package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.UserTypeDTO;
import com.example.filmreviewapplication.exception.UserTypeNotFoundException;
import com.example.filmreviewapplication.mapper.UserTypeMapper;
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

    public UserTypeDTO createUserType(UserTypeDTO userTypeDto) {

        UserType userType = UserTypeMapper.toEntity(userTypeDto);
        userTypeRepository.save(userType);
        return UserTypeMapper.toUserTypeDTO(userType);
    }

    public List<UserTypeDTO> getAllUserTypes() {

        List<UserType> userTypes = userTypeRepository.findAll();
        return UserTypeMapper.toListUserTypeDTO(userTypes);
    }

    public UserTypeDTO getUserTypeDTOById(Long id) {

        UserType userType = userTypeRepository.findById(id)
                .orElseThrow(UserTypeNotFoundException::new);
        return UserTypeMapper.toUserTypeDTO(userType);
    }

    public UserType getUserTypeById(Long id) {

        UserType userType = userTypeRepository.findById(id)
                .orElseThrow(UserTypeNotFoundException::new);
        return userType;
    }

    public void deleteUserTypeById(Long id) {

        UserType userTypeToDelete = userTypeRepository

                .findById(id)
                .orElseThrow(UserTypeNotFoundException::new);

        userTypeToDelete.setIsActive(false);
        userTypeRepository.save(userTypeToDelete);

    }

    public UserTypeDTO updateUserType(Long id, UserTypeDTO userTypeDto) {

        UserType userTypeToUpdate = userTypeRepository
                .findById(id)
                .orElseThrow(UserTypeNotFoundException::new);

        if (Objects.nonNull(userTypeToUpdate)) {

            userTypeToUpdate.setName(userTypeDto.getName());
            userTypeRepository.save(userTypeToUpdate);

            return UserTypeMapper.toUserTypeDTO(userTypeToUpdate);
        }

        return  UserTypeMapper.toUserTypeDTO(userTypeToUpdate);

    }
}



