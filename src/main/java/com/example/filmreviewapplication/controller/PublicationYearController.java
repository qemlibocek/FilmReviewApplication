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
    public ResponseEntity<List<PublicationYearDTO>> getAllPublicationYears() {

        List<PublicationYearDTO> publicationYearListDTO = publicationYearService.getAllPublicationYears();
        return ResponseEntity.ok().body(publicationYearListDTO);
    }

    @GetMapping("/id")
    public ResponseEntity<PublicationYearDTO> getPublicationYearById(@RequestParam Long id) {

        PublicationYearDTO publicationYearDTO = publicationYearService.getPublicationYearById(id);
        return ResponseEntity.ok().body(publicationYearDTO);
    }

    @PutMapping
    public ResponseEntity<PublicationYearDTO> updatePublicationYear(@RequestBody PublicationYearDTO publicationYearDTO) {

        PublicationYearDTO newPubYearDTO = publicationYearService.updatePublicationYear(publicationYearDTO, publicationYearDTO.getId());
        return ResponseEntity.ok().body(newPubYearDTO);
    }

    @DeleteMapping
    public ResponseEntity<PublicationYear> deletePublicationYear(@RequestParam Long id) {

        publicationYearService.deletePublicationYear(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PublicationYearDTO> createPublicationYear(@RequestBody PublicationYearDTO publicationYearDTO) {

        PublicationYearDTO newPubYearDTO = publicationYearService.createPublicationYear(publicationYearDTO);
        return ResponseEntity.ok().body(newPubYearDTO);
    }

}
