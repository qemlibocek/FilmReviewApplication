package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.ActorDTO;
import com.example.filmreviewapplication.exception.ActorNotFoundException;
import com.example.filmreviewapplication.mapper.ActorMapper;
import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.repository.ActorRepository;
import com.example.filmreviewapplication.repository.FilmRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SQLRestriction("is_active = true")
@RequiredArgsConstructor
public class ActorService {
    ActorRepository actorRepository;
    FilmRepository filmRepository;

    public List<ActorDTO> getAllActors() {
        return ActorMapper.toListActorDTO(actorRepository.findAll());
    }

    public ActorDTO createActor(ActorDTO actorDTO) {
        List<Film> films = actorDTO.getFilmIds().stream()
                .map(filmId -> filmRepository.findById(filmId)
                        .orElseThrow(ActorNotFoundException::new))
                .toList();

        Actor actor = ActorMapper.toEntity(actorDTO, films);
        actor = actorRepository.save(actor);
        return ActorMapper.toActorDTO(actor);
    }

    public ActorDTO getActorById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);
        return ActorMapper.toActorDTO(actor);
    }

    public void deleteActor(Long id) {
        var actor = actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);
        actor.setIsActive(false);
        actorRepository.save(actor);
    }

    public ActorDTO updateActor(Long id, ActorDTO actorDTO) {
        var actorForUpdate = actorRepository.findById(id)
                .orElseThrow(ActorNotFoundException::new);

        List<Film> films = actorDTO.getFilmIds().stream()
                .map(filmId -> filmRepository.findById(filmId)
                        .orElseThrow(ActorNotFoundException::new))
                .collect(Collectors.toList());

        if (Objects.nonNull(actorForUpdate)) {
            actorForUpdate.setName(actorDTO.getName());
            actorForUpdate.setSurname(actorDTO.getSurname());
            actorForUpdate.setFilms(films);
            actorForUpdate = actorRepository.save(actorForUpdate);
        }
        return ActorMapper.toActorDTO(actorForUpdate);
    }
}