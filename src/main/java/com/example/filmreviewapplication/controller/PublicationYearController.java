package com.example.filmreviewapplication.controller;

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
    public ResponseEntity<List<PublicationYear>> getAllPublicationYears() {

        List<PublicationYear> publicationYearList = publicationYearService.getAllPublicationYears();
        return ResponseEntity.ok().body(publicationYearList);
    }

    @GetMapping("/id")
    public ResponseEntity<PublicationYear> getPublicationYearById(@RequestParam Long id) {

        PublicationYear publicationYear = publicationYearService.getPublicationYearById(id);
        return ResponseEntity.ok().body(publicationYear);
    }

    @PutMapping
    public ResponseEntity<PublicationYear> updatePublicationYear(@RequestBody PublicationYear publicationYear) {

        PublicationYear newPubYear = publicationYearService.updatePublicationYear(publicationYear, publicationYear.getId());
        return ResponseEntity.ok().body(newPubYear);
    }

    @DeleteMapping
    public ResponseEntity<PublicationYear> deletePublicationYear(@RequestParam Long id) {

        publicationYearService.deletePublicationYear(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PublicationYear> createPublicationYear(@RequestBody PublicationYear publicationYear) {

        PublicationYear newPubYear = publicationYearService.createPublicationYear(publicationYear);
        return ResponseEntity.ok().body(newPubYear);
    }

}
