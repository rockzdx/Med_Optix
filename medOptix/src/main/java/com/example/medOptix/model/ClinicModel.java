package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinic")
public class ClinicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long clinic_id;
    String name;
    String description;
    String address;
    String email;

}
