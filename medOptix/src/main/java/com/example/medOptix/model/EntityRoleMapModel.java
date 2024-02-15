package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
public class EntityRoleMapModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ermId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entityId",referencedColumnName = "entityId")
    private EntityModel entityModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId",referencedColumnName = "roleId")
    private RolesModel rolesModel;

    public Long getErmId() {
        return ermId;
    }

    public void setErmId(Long ermId) {
        this.ermId = ermId;
    }

    public EntityModel getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel entityModel) {
        this.entityModel = entityModel;
    }

    public RolesModel getRolesModel() {
        return rolesModel;
    }

    public void setRolesModel(RolesModel rolesModel) {
        this.rolesModel = rolesModel;
    }
}
