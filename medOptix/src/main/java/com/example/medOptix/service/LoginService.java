package com.example.medOptix.service;

import com.example.medOptix.model.EntityModel;
import com.example.medOptix.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final EntityRepository entityRepository;

    public LoginService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }
}
