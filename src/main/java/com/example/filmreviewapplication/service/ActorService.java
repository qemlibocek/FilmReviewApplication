package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.repository.ActorRepository;
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
public class ActorService {

    ActorRepository actorRepository;

    public List<Actor> getAllActors() {

        return actorRepository.findAll();
    }

    public Actor createActor(Actor actor) {

        return actorRepository.save(actor);
    }

    public Actor getActorById(Long id) {

        return actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    public void deleteActor(Long id) {

        var actor = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));
        actor.setIsActive(false);
        actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor actor) {

        var actorForUpdate = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
        if (Objects.nonNull(actorForUpdate)) {
            actorForUpdate.setName(actor.getName());
            actorForUpdate.setSurname(actor.getSurname());
            return actorForUpdate;
        }
        return actorForUpdate;
    }
}
