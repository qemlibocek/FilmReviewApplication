package com.example.filmreviewapplication.model.entity;

import com.example.filmreviewapplication.model.enums.Genre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "films")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    Long id;
    @Column(nullable = false)
    String name;
    Float score;
    @Enumerated(EnumType.STRING)
    Genre genre;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_year_id", referencedColumnName = "id", nullable = false)
    PublicationYear publicationYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
    Director director;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_actors",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    List<Actor> actors;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

}
