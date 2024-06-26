package com.example.medOptix.service;

import com.example.medOptix.model.ClinicModel;
import com.example.medOptix.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {
    private ClinicRepository clinicRepository;

    public SearchService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }
    public List<ClinicModel> listAll() {
        return clinicRepository.findAll();
    }

//    public Optional<ClinicModel> getAllClinicDetails() {
//        return clinicRepository.findByName();
//    }

//    public ClinicModel getClinicDetails(String name){
//        return clinicRepository.findByName(name).get();
//    }
}
