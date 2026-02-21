package com.buildings.entity;

import com.buildings.entity.Apartment;
import com.buildings.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building extends BaseEntity {

    @Column(nullable = false)
    private String name;

    // ===============================
    // RELATIONSHIPS
    // ===============================
//
//    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Apartment> apartments = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    private List<Apartment> apartments;


}
