package com.example.filmreviewapplication.service;

import com.example.filmreviewapplication.dto.PublicationYearDTO;
import com.example.filmreviewapplication.exception.FilmNotFoundException;
import com.example.filmreviewapplication.exception.PubYearNotFoundException;
import com.example.filmreviewapplication.mapper.DirectorMapper;
import com.example.filmreviewapplication.mapper.PublicationYearMapper;
import com.example.filmreviewapplication.model.entity.Director;
import com.example.filmreviewapplication.model.entity.Film;
import com.example.filmreviewapplication.model.entity.PublicationYear;
import com.example.filmreviewapplication.repository.FilmRepository;
import com.example.filmreviewapplication.repository.PublicationYearRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@SQLRestriction("is_active = true")
public class PublicationYearService {

    PublicationYearRepository publicationYearRepository;
    FilmRepository filmRepository;

    public List<PublicationYearDTO> getAllPublicationYears() {

        return PublicationYearMapper.toListPublicationYearDTO(publicationYearRepository.findAll());
    }

    public PublicationYearDTO getPublicationYearById(Long id) {

        PublicationYear publicationYear = publicationYearRepository.findById(id)
                .orElseThrow(PubYearNotFoundException::new);

        return PublicationYearMapper.toPublicationYearDTO(publicationYear);
    }

    public PublicationYearDTO createPublicationYear(PublicationYearDTO publicationYearDTO) {
        List<Film> films = publicationYearDTO.getFilmIds().stream()
                .map(filmId -> filmRepository.findById(filmId)
                        .orElseThrow(FilmNotFoundException::new))
                .toList();

        PublicationYear publicationYear = PublicationYearMapper.toEntity(publicationYearDTO, films);
        publicationYear = publicationYearRepository.save(publicationYear);

        return PublicationYearMapper.toPublicationYearDTO(publicationYear);
    }

    public void deletePublicationYear(Long id) {

        PublicationYear publicationYear = publicationYearRepository.findById(id)
                .orElseThrow(PubYearNotFoundException::new);

        publicationYear.setIsActive(false);
        publicationYearRepository.save(publicationYear);
    }

    public PublicationYearDTO updatePublicationYear(PublicationYearDTO publicationYearDTO, Long id) {

        PublicationYear publicationYearToUpdate = publicationYearRepository.findById(id)
                .orElseThrow(PubYearNotFoundException::new);

        if (Objects.nonNull(publicationYearToUpdate)) {
            publicationYearToUpdate.setYear(publicationYearDTO.getYear());
            publicationYearRepository.save(publicationYearToUpdate);
        }

        return PublicationYearMapper.toPublicationYearDTO(publicationYearToUpdate);
    }
}
