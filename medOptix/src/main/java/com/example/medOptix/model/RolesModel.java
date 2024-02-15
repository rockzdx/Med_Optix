package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
public class RolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;

    @OneToOne(mappedBy = "rolesModel")
    private EntityRoleMapModel entityRoleMapModel;

    public EntityRoleMapModel getEntityRoleMapModel() {
        return entityRoleMapModel;
    }

    public void setEntityRoleMapModel(EntityRoleMapModel entityRoleMapModel) {
        this.entityRoleMapModel = entityRoleMapModel;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long role_id) {
        this.roleId = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_name) {
        this.roleName = role_name;
    }

    @Override
    public String toString() {
        return "RolesModel{" +
                "role_id=" + roleId +
                ", role_name='" + roleName + '\'' +
                '}';
    }
}
