package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.service.DirectorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
