package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EntityCreds")
public class CredentialModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long entity_cred_id;

    String hashed_pwd;
    Integer active_flag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entity_id")
    private EntityModel credentials;

}
