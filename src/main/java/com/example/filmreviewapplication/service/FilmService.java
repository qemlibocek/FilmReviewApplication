package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.repository.FilmRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmService {

    FilmRepository filmRepository;

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }
}
