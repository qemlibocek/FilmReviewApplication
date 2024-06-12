package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.service.DirectorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/directors")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DirectorController {

    DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors(){

        List<Director> directorList = directorService.getAllDirectors();
        return ResponseEntity.ok().body(directorList);
    }

    @PutMapping
    public ResponseEntity<Director> updateDirector(@RequestBody Director director){

        var newDirector = directorService.updateDirector(director.getId(), director);
        return ResponseEntity.ok().body(newDirector);
    }

    @GetMapping("/id")
    public ResponseEntity<Director> getDirectorById(@RequestParam Long id){

        var director = directorService.getDirectorById(id);
        return ResponseEntity.ok().body(director);
    }

    @DeleteMapping
    public ResponseEntity<Director> deleteDirector(@RequestParam Long id){

        directorService.deleteDirectorById(id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director){

        var directorForCreation = directorService.createDirector(director);
        return ResponseEntity.ok().body(directorForCreation);
    }
}
