package com.buildings.entity;

import com.buildings.entity.Apartment;
import com.buildings.entity.BaseEntity;
import com.buildings.entity.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // ADMIN có thể null apartment
    @ManyToOne
    @JsonBackReference
    private Apartment apartment;

}
