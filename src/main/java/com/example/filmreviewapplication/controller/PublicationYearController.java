package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.service.PublicationYearService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
