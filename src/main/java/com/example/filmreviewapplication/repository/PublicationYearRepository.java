package com.example.filmreviewapplication.repository;

import com.example.filmreviewapplication.model.entity.PublicationYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationYearRepository extends JpaRepository<PublicationYear, Long> {
}
