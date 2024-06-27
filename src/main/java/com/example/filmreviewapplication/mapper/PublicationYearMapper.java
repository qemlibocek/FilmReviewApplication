package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.PublicationYearDTO;
import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.model.entity.PublicationYear;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicationYearMapper {

    public static PublicationYearDTO toPublicationYearDTO (PublicationYear publicationYear){

        if (publicationYear == null){
            return null;
        }

        PublicationYearDTO publicationYearDTO = new PublicationYearDTO();
        publicationYearDTO.setId(publicationYear.getId());
        publicationYearDTO.setYear(publicationYear.getYear());
        publicationYearDTO.setFilmIds(publicationYear.getFilms().stream()
                .map(Film::getId)
                .collect(Collectors.toList()));

        return publicationYearDTO;
    }

    public static PublicationYear toEntity (PublicationYearDTO publicationYearDTO, List<Film> films){

        if (publicationYearDTO == null){
            return null;
        }

        PublicationYear publicationYear = new PublicationYear();
        publicationYear.setYear(publicationYearDTO.getYear());
        publicationYear.setId(publicationYearDTO.getId());
        publicationYear.setFilms(films);

        return publicationYear;
    }

    public static List<PublicationYearDTO> toListPublicationYearDTO(List<PublicationYear> publicationYears){

        return publicationYears.stream()
                .map(PublicationYearMapper::toPublicationYearDTO)
                .collect(Collectors.toList());
    }
}
