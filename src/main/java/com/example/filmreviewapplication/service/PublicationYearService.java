package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.repository.PublicationYearRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PublicationYearService {

    PublicationYearRepository publicationYearRepository;

    public List<PublicationYear> getAllPublicationYears() {

        return publicationYearRepository.findAll();
    }
}
