package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.DirectorDTO;
import com.example.filmreviewapplication.dto.FilmDTO;
import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.model.entity.Film;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorMapper {

    public static DirectorDTO toDirectorDTO (Director director){

        if (director == null){
            return null;
        }
        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setSurname(director.getSurname());
        directorDTO.setName(director.getName());
        directorDTO.setId(director.getId());
        directorDTO.setFilmIds(director.getFilms().stream().map(Film::getId).collect(Collectors.toList()));

        return directorDTO;
    }

    public static Director toEntity (DirectorDTO directorDTO, List<Film> films){

        if (directorDTO == null){
            return null;
        }
        Director director = new Director();
        director.setSurname(directorDTO.getSurname());
        director.setName(directorDTO.getName());
        director.setId(directorDTO.getId());
        director.setFilms(films);

        return director;
    }

    public static List<DirectorDTO> toListDirectorDTO(List<Director> directors){

        return directors.stream()
                .map(DirectorMapper::toDirectorDTO)
                .collect(Collectors.toList());
    }
}
