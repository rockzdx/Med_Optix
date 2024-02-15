package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EntityCreds")
public class CredentialModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityCredId;

    private String hashedPwd;
    private Integer activeFlag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entityId",referencedColumnName = "entityId")
    private EntityModel entityModel;

    public EntityModel getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(EntityModel entityModel) {
        this.entityModel = entityModel;
    }

    public Long getEntityCredId() {
        return entityCredId;
    }

    public void setEntityCredId(Long entity_cred_id) {
        this.entityCredId = entity_cred_id;
    }

    public String getHashedPwd() {
        return hashedPwd;
    }

    public void setHashedPwd(String hashed_pwd) {
        this.hashedPwd = hashed_pwd;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer active_flag) {
        this.activeFlag = active_flag;
    }
}
