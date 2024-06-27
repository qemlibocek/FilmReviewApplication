package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.FilmDTO;
import com.example.filmreviewapplication.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class
FilmMapper {

    public static FilmDTO toFilmDTO(Film film) {

        if (film == null) {
            return null;
        }
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setId(film.getId());
        filmDTO.setName(film.getName());
        filmDTO.setScore(film.getScore());
        filmDTO.setActorIds(film.getActors().stream()
                .map(Actor::getId)
                .collect(Collectors.toList())
        );
        filmDTO.setPublicationYearId(film.getPublicationYear().getId());
        filmDTO.setDirectorId(film.getDirector().getId());
        filmDTO.setGenre(filmDTO.getGenre());

        return filmDTO;
    }

    public static Film toEntity(FilmDTO filmDTO, PublicationYear publicationYear, Director director, List<Actor> actors) {

        if (filmDTO == null) {
            return null;
        }
        Film film = new Film();
        film.setName(filmDTO.getName());
        film.setScore(filmDTO.getScore());
        film.setDirector(director);
        film.setGenre(filmDTO.getGenre());
        film.setId(filmDTO.getId());
        film.setPublicationYear(publicationYear);
        film.setActors(actors);

        return film;
    }

    public static List<FilmDTO> toListFilmDTO(List<Film> films){

        return films.stream()
                .map(FilmMapper::toFilmDTO)
                .collect(Collectors.toList());
    }
}
