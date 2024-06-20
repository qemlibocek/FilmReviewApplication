package com.example.filmreviewapplication.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserTypeDTO {

    Long user_types_id;
    String name;
    Boolean isActive;
}
