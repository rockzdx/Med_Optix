package com.example.medOptix.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "entity")
public class EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long entity_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonModel person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinic_id")
    private ClinicModel clinic;

    public Long getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Long entity_id) {
        this.entity_id = entity_id;
    }
}
