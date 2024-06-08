package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.repository.FilmRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmService {

    FilmRepository filmRepository;

    public List<Film> getAllFilms() {

        return filmRepository.findAll();
    }

    public Film addFilm(Film film) {

        var newFilm = filmRepository.save(film);
        return newFilm;

    }

    public Film getFilmById(Long id) {
        Film film = filmRepository.findById(id)
                .orElse(null);
        return film;
    }

    public Film updateFilm(Film film, Long id) {

        var filmToUpdate = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));

        if (Objects.nonNull(filmToUpdate)) {
            filmToUpdate.setId(film.getId());
            filmToUpdate.setName(film.getName());
            filmToUpdate.setGenre(film.getGenre());
            filmToUpdate.setScore(film.getScore());

            filmRepository.save(filmToUpdate);

            return filmToUpdate;
        }
        return filmToUpdate;
    }

    public void deleteFilm(Long id) {
        var film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));

        film.setIsActive(false);
        filmRepository.save(film);
    }
}
