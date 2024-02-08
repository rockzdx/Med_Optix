package com.example.medOptix.repository;

import com.example.medOptix.model.CredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<CredentialModel,Long> {

}
