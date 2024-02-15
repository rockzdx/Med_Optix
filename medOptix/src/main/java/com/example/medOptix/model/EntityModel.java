package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entity")
public class EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId",referencedColumnName = "personId")
    private PersonModel person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinicId",referencedColumnName = "clinicId")
    private ClinicModel clinic;

    @OneToOne(mappedBy = "entityModel")
    private CredentialModel credentialModel;

    public CredentialModel getCredentialModel() {
        return credentialModel;
    }

    public void setCredentialModel(CredentialModel credentialModel) {
        this.credentialModel = credentialModel;
    }

    @OneToOne(mappedBy = "entityModel")
    private EntityRoleMapModel entityRoleMapModel;

    public EntityRoleMapModel getEntityRoleMapModel() {
        return entityRoleMapModel;
    }

    public void setEntityRoleMapModel(EntityRoleMapModel entityRoleMapModel) {
        this.entityRoleMapModel = entityRoleMapModel;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public ClinicModel getClinic() {
        return clinic;
    }

    public void setClinic(ClinicModel clinic) {
        this.clinic = clinic;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entity_id) {
        this.entityId = entity_id;
    }
}
