package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.service.FilmService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}
