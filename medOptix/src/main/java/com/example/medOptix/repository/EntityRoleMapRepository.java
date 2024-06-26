package com.example.medOptix.repository;

import com.example.medOptix.model.EntityModel;
import com.example.medOptix.model.EntityRoleMapModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRoleMapRepository extends JpaRepository<EntityRoleMapModel,Long> {

    EntityRoleMapModel findByEntityModel(EntityModel entityModel);

}
