package com.example.medOptix.repository;

import com.example.medOptix.model.EntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<EntityModel,Long> {

}
