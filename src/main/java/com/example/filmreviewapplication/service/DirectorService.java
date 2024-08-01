package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.DirectorDTO;
import com.example.filmreviewapplication.exception.DirectorNotFoundException;
import com.example.filmreviewapplication.mapper.DirectorMapper;
import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.repository.DirectorRepository;
import com.example.filmreviewapplication.repository.FilmRepository;
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
    FilmRepository filmRepository;

    public List<DirectorDTO> getAllDirectors() {

        return DirectorMapper.toListDirectorDTO(directorRepository.findAll());
    }

    public DirectorDTO getDirectorById(Long id) {

        Director director = directorRepository.findById(id)
                .orElseThrow(DirectorNotFoundException::new);

        return DirectorMapper.toDirectorDTO(director);
    }

    public DirectorDTO createDirector(DirectorDTO directorDTO) {

        List<Film> films = directorDTO.getFilmIds().stream()
                .map(filmId -> filmRepository.findById(filmId)
                        .orElseThrow(DirectorNotFoundException::new))
                .toList();

        Director director = DirectorMapper.toEntity(directorDTO, films);
        director = directorRepository.save(director);

        return DirectorMapper.toDirectorDTO(director);
    }

    public void deleteDirectorById(Long id) {

        var director = directorRepository.findById(id)
                .orElseThrow(DirectorNotFoundException::new);
        director.setIsActive(false);
        directorRepository.save(director);
    }

    public DirectorDTO updateDirector(Long id, DirectorDTO directorDTO) {

        var directorForUpdate = directorRepository.findById(id)
                .orElseThrow(DirectorNotFoundException::new);

        if (Objects.nonNull(directorForUpdate)) {
            directorForUpdate.setName(directorDTO.getName());
            directorForUpdate.setSurname(directorDTO.getSurname());
            directorRepository.save(directorForUpdate);
        }
        return DirectorMapper.toDirectorDTO(directorForUpdate);
    }
}
