package com.example.filmreviewapplication.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileDTO {

    String firstName;
    String lastName;
    String username;
    String country;
    String phoneNumber;
    String password;
    Integer age;
    Long id;
    Long userTypeId;


}
