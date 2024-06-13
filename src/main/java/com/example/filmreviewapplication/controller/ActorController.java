package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Actor;
import com.example.filmreviewapplication.service.ActorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/id")
    public ResponseEntity<Actor> getActorById(@RequestParam Long id){

        Actor actor = actorService.getActorById(id);
        return ResponseEntity.ok().body(actor);
    }

    @PutMapping
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor){

        Actor actorForUpdate = actorService.updateActor(actor.getId(), actor);
        return ResponseEntity.ok().body(actorForUpdate);
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){

        Actor actorForCreation = actorService.createActor(actor);
        return ResponseEntity.ok().body(actorForCreation);
    }

    @DeleteMapping
    public ResponseEntity<Actor> deleteActor(@RequestParam Long id){

        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}
