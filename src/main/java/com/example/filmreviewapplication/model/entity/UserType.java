package com.example.filmreviewapplication.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user_types")
@SQLRestriction("active = true")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long user_types_id;
    String name;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Boolean isActive = true;

}
