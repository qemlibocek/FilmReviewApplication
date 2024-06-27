package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.FilmDTO;
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
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<FilmDTO> filmList = filmService.getAllFilms();
        return ResponseEntity.ok().body(filmList);
    }

    @PostMapping
    public ResponseEntity<FilmDTO> addFilm(@RequestBody FilmDTO filmDTO) {
        FilmDTO newFilm = filmService.createFilm(filmDTO);
        return ResponseEntity.ok().body(newFilm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable Long id) {
        FilmDTO film = filmService.getFilmById(id);
        return ResponseEntity.ok().body(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        FilmDTO updatedFilm = filmService.updateFilm(filmDTO, id);
        return ResponseEntity.ok().body(updatedFilm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilmById(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}