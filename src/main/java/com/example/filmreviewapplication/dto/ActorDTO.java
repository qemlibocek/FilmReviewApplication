package com.example.filmreviewapplication.dto;

import com.example.filmreviewapplication.model.entity.Film;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActorDTO {

    Long id;
    String name;
    String surname;
    List<Long> filmIds;
}
