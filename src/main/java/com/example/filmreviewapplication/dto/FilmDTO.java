package com.example.filmreviewapplication.dto;

import com.example.filmreviewapplication.model.enums.Genre;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmDTO {

    Long id;
    String name;
    Float score;
    Genre genre;
    Long publicationYearId;
    Long directorId;
    List<Long> actorIds;

}
