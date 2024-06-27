package com.example.filmreviewapplication.mapper;

import com.example.filmreviewapplication.dto.ActorDTO;
import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.model.entity.Film;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMapper {

    public static ActorDTO toActorDTO(Actor actor) {
        if (actor == null) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(actor.getId());
        actorDTO.setName(actor.getName());
        actorDTO.setSurname(actor.getSurname());
        actorDTO.setFilmIds(actor.getFilms().stream()
                .map(Film::getId)
                .collect(Collectors.toList()));
        return actorDTO;
    }

    public static Actor toEntity(ActorDTO actorDTO, List<Film> films) {
        if (actorDTO == null) {
            return null;
        }

        Actor actor = new Actor();
        actor.setId(actorDTO.getId());
        actor.setName(actorDTO.getName());
        actor.setSurname(actorDTO.getSurname());
        actor.setFilms(films);
        return actor;
    }

    public static List<ActorDTO> toListActorDTO(List<Actor> actors){

        return actors.stream()
                .map(ActorMapper::toActorDTO)
                .collect(Collectors.toList());
    }
}
