package com.example.filmreviewapplication.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Data
@Table(name = "user_types")
@SQLRestriction("is_active = true")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserType implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long user_types_id;
    String name;

    @OneToOne(mappedBy = "userType", cascade = CascadeType.ALL)
    UserProfile userProfile;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    Boolean isActive = true;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
