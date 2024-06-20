package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.service.FilmService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/films")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FilmController {

    FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms(){

        List<Film> filmList = filmService.getAllFilms();
        return ResponseEntity.ok().body(filmList);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film){

        Film newFilm = filmService.addFilm(film);
        return ResponseEntity.ok().body(newFilm);
    }

    @GetMapping("/id")
    public ResponseEntity<Film> getFilmById(@RequestParam Long id){
        Film film = filmService.getFilmById(id);
        return ResponseEntity.ok().body(film);
    }

    @PutMapping
    public ResponseEntity<Film> updateFilm(@RequestBody Film film){

        var newFilm = filmService.updateFilm(film, film.getId());
        return ResponseEntity.ok().body(newFilm);
    }

    @DeleteMapping
    public ResponseEntity<Film> deleteFilmById(@RequestParam Long id){

        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
