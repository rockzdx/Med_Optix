package com.example.medOptix.repository;

import com.example.medOptix.model.ClinicModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicRepository extends JpaRepository<ClinicModel,Long> {
    Optional<ClinicModel> findByEmailAndPassword(String email, String password);
    Optional<ClinicModel> findByEmail(String email);
//    Optional<ClinicModel> findByName(String name);
}
