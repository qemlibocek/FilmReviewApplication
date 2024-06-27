package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.UserTypeDTO;
import com.example.filmreviewapplication.model.entity.UserType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTypeMapper {

    public static UserTypeDTO toUserTypeDTO(UserType userType){

        if (userType == null){
            return null;
        }

        UserTypeDTO userTypeDTO = new UserTypeDTO();
        userTypeDTO.setUser_types_id(userType.getUser_types_id());
        userTypeDTO.setName(userType.getName());
        userTypeDTO.setIsActive(userType.getIsActive());

        return userTypeDTO;
    }

    public static UserType toEntity(UserTypeDTO userTypeDTO){

        if (userTypeDTO == null){
            return null;
        }

        UserType userType = new UserType();
        userType.setName(userTypeDTO.getName());
        userType.setUser_types_id(userTypeDTO.getUser_types_id());
        userType.setIsActive(userTypeDTO.getIsActive());

        return userType;
    }

    public static List<UserTypeDTO> toListUserTypeDTO(List<UserType> userTypes){

        return userTypes.stream()
                .map(UserTypeMapper::toUserTypeDTO)
                .collect(Collectors.toList());
    }
}
