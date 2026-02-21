package com.buildings.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment extends BaseEntity {

    @Column(nullable = false)
    private String name;

    // ===============================
    // RELATIONSHIPS
    // ===============================

    @ManyToOne
    @JsonBackReference
    private Building building;


    @OneToMany(mappedBy = "apartment")
    @JsonIgnore
    private List<User> users;



    @OneToMany(mappedBy = "apartment")
    @JsonIgnore
    private List<Bill> bills;

}
