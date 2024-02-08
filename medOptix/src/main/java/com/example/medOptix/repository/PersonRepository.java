package com.example.medOptix.repository;

import com.example.medOptix.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonModel,Long> {
    Optional<PersonModel> findByEmailAndPassword(String email,String password);
    Optional<PersonModel>findByEmail(String email);
}
