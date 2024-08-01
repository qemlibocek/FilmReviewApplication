package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.PublicationYearDTO;
import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.service.PublicationYearService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/publicationYears")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PublicationYearController {

    PublicationYearService publicationYearService;

    @GetMapping
    public ResponseEntity<List<?>> getAllPublicationYears() {

        List<PublicationYearDTO> publicationYearListDTO = publicationYearService.getAllPublicationYears();
        return ResponseEntity.ok().body(publicationYearListDTO);
    }

    @GetMapping("/byId/id")
    public ResponseEntity<?> getPublicationYearById(@RequestParam Long id) {

        PublicationYearDTO publicationYearDTO = publicationYearService.getPublicationYearById(id);
        return ResponseEntity.ok().body(publicationYearDTO);
    }

    @PutMapping
    public ResponseEntity<?> updatePublicationYear(@RequestBody PublicationYearDTO publicationYearDTO) {

        PublicationYearDTO newPubYearDTO = publicationYearService.updatePublicationYear(publicationYearDTO, publicationYearDTO.getId());
        return ResponseEntity.ok().body(newPubYearDTO);
    }

    @DeleteMapping("/byId/{id}")
    public ResponseEntity<?> deletePublicationYear(@RequestParam Long id) {

        publicationYearService.deletePublicationYear(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> createPublicationYear(@RequestBody PublicationYearDTO publicationYearDTO) {

        PublicationYearDTO newPubYearDTO = publicationYearService.createPublicationYear(publicationYearDTO);
        return ResponseEntity.ok().body(newPubYearDTO);
    }

}
