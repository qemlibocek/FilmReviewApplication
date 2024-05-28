package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.service.ActorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/actors")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ActorController {

    ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors (){

        List<Actor> actorList = actorService.getAllActors();
        return ResponseEntity.ok().body(actorList);
    }




}
