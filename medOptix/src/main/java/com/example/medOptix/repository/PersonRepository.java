package com.example.medOptix.repository;

import com.example.medOptix.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonModel,Long> {
    PersonModel findByEmailAndPassword(String email,String password);
    PersonModel findByEmail(String email);



}
