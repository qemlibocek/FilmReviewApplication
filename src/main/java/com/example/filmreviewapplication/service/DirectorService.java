package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.repository.DirectorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DirectorService {

    DirectorRepository directorRepository;

    public List<Director> getAllDirectors(){

        return directorRepository.findAll();
    }
}
