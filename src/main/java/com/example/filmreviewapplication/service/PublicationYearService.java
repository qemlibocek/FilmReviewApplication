package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.repository.PublicationYearRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PublicationYearService {

    PublicationYearRepository publicationYearRepository;

    public List<PublicationYear> getAllPublicationYears() {

        return publicationYearRepository.findAll();
    }

    public PublicationYear getPublicationYearById(Long id) {

        PublicationYear publicationYear = publicationYearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication Year Not Found"));
        return publicationYear;
    }

    public PublicationYear createPublicationYear(PublicationYear publicationYear) {

        return publicationYearRepository.save(publicationYear);
    }

    public void deletePublicationYear(Long id) {

        PublicationYear publicationYear = publicationYearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication Year Not Found"));

        publicationYear.setIsActive(false);
        publicationYearRepository.save(publicationYear);
    }

    public PublicationYear updatePublicationYear(PublicationYear publicationYear, Long id) {

        PublicationYear publicationYearToUpdate = publicationYearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication Year Not Found"));

        if (Objects.nonNull(publicationYearToUpdate)) {
            publicationYearToUpdate.setYear(publicationYear.getYear());
            publicationYearRepository.save(publicationYearToUpdate);
            return publicationYearToUpdate;
        }
        return publicationYearToUpdate;

    }
}
