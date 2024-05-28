package com.example.filmreviewapplication.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "actors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String surname;

    @UpdateTimestamp
    LocalDateTime updatedAt;
    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime createdAt;
}
