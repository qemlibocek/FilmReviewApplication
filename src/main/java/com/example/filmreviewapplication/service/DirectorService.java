package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.repository.DirectorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SQLRestriction("is_active = true")

@RequiredArgsConstructor
public class DirectorService {

    DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {

        return directorRepository.findAll();
    }

    public Director getDirectorById(Long id) {

        return directorRepository.findById(id)
                .orElse(null);

    }

    public Director createDirector(Director director) {

        return directorRepository.save(director);
    }

    public void deleteDirectorById(Long id) {

        var director = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));
        director.setIsActive(false);
        directorRepository.save(director);
    }

    public Director updateDirector(Long id, Director director) {

        var directorForUpdate = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));

        if (Objects.nonNull(directorForUpdate)) {
            directorForUpdate.setName(director.getName());
            directorForUpdate.setSurname(director.getSurname());
            directorRepository.save(directorForUpdate);
            return directorForUpdate;
        }
        return directorForUpdate;
    }
}
