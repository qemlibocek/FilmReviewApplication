package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.FilmDTO;
import com.example.filmreviewapplication.exception.ActorNotFoundException;
import com.example.filmreviewapplication.exception.DirectorNotFoundException;
import com.example.filmreviewapplication.exception.FilmNotFoundException;
import com.example.filmreviewapplication.exception.PubYearNotFoundException;
import com.example.filmreviewapplication.mapper.FilmMapper;
import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.repository.ActorRepository;
import com.example.filmreviewapplication.repository.DirectorRepository;
import com.example.filmreviewapplication.repository.FilmRepository;
import com.example.filmreviewapplication.repository.PublicationYearRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@SQLRestriction("is_active = true")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmService {

    FilmRepository filmRepository;
    DirectorRepository directorRepository;
    PublicationYearRepository publicationYearRepository;
    FilmMapper filmMapper;
    ActorRepository actorRepository;


    public List<FilmDTO> getAllFilms() {
        return FilmMapper.toListFilmDTO(filmRepository.findAll());
    }

    public FilmDTO createFilm(FilmDTO filmDTO) {
        PublicationYear publicationYear = publicationYearRepository.findById(filmDTO.getPublicationYearId())
                .orElseThrow(PubYearNotFoundException::new);
        Director director = directorRepository.findById(filmDTO.getDirectorId())
                .orElseThrow(DirectorNotFoundException::new);
        List<Actor> actors = filmDTO.getActorIds().stream()
                .map(actorId -> actorRepository.findById(actorId)
                        .orElseThrow(ActorNotFoundException::new))
                .collect(Collectors.toList());

        Film film = FilmMapper.toEntity(filmDTO, publicationYear, director, actors);
        film = filmRepository.save(film);
        return FilmMapper.toFilmDTO(film);
    }

    public FilmDTO getFilmById(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(FilmNotFoundException::new);
        return FilmMapper.toFilmDTO(film);
    }

    public FilmDTO updateFilm(FilmDTO filmDTO, Long id) {
        var filmToUpdate = filmRepository.findById(id)
                .orElseThrow(FilmNotFoundException::new);

        if (Objects.nonNull(filmToUpdate)) {
            PublicationYear publicationYear = publicationYearRepository.findById(filmDTO.getPublicationYearId())
                    .orElseThrow(PubYearNotFoundException::new);
            Director director = directorRepository.findById(filmDTO.getDirectorId())
                    .orElseThrow(DirectorNotFoundException::new);
            List<Actor> actors = filmDTO.getActorIds().stream()
                    .map(actorId -> actorRepository.findById(actorId)
                            .orElseThrow(ActorNotFoundException::new))
                    .collect(Collectors.toList());

            filmToUpdate.setName(filmDTO.getName());
            filmToUpdate.setGenre(filmDTO.getGenre());
            filmToUpdate.setScore(filmDTO.getScore());
            filmToUpdate.setPublicationYear(publicationYear);
            filmToUpdate.setDirector(director);
            filmToUpdate.setActors(actors);

            filmRepository.save(filmToUpdate);
        }

        return FilmMapper.toFilmDTO(filmToUpdate);
    }

    public void deleteFilm(Long id) {
        var film = filmRepository.findById(id)
                .orElseThrow(FilmNotFoundException::new);
        film.setIsActive(false);
        filmRepository.save(film);
    }
}