package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.repository.ActorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ActorService {

    ActorRepository actorRepository;

    public List<Actor> getAllActors (){

        return actorRepository.findAll();
    }


}
