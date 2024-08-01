package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.DirectorDTO;
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
    public ResponseEntity<List<?>> getAllDirectors() {
        List<DirectorDTO> directorList = directorService.getAllDirectors();
        return ResponseEntity.ok().body(directorList);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getDirectorById(@PathVariable Long id) {
        DirectorDTO director = directorService.getDirectorById(id);
        return ResponseEntity.ok().body(director);
    }

    @PostMapping
    public ResponseEntity<?> createDirector(@RequestBody DirectorDTO directorDTO) {
        DirectorDTO newDirector = directorService.createDirector(directorDTO);
        return ResponseEntity.ok().body(newDirector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDTO> updateDirector(@PathVariable Long id, @RequestBody DirectorDTO directorDTO) {
        DirectorDTO updatedDirector = directorService.updateDirector(id, directorDTO);
        return ResponseEntity.ok().body(updatedDirector);
    }

    @DeleteMapping("/byId/{id}")
    public ResponseEntity<Void> deleteDirectorById(@PathVariable Long id) {
        directorService.deleteDirectorById(id);
        return ResponseEntity.noContent().build();
    }
}