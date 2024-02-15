package com.example.medOptix.service;

import com.example.medOptix.model.ClinicModel;
import com.example.medOptix.model.PersonModel;
import com.example.medOptix.repository.ClinicRepository;
import com.example.medOptix.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static PersonRepository personRepository;
    private static ClinicRepository clinicRepository;
    public AuthService(PersonRepository personRepository, ClinicRepository clinicRepository) {
        AuthService.personRepository = personRepository;
        AuthService.clinicRepository = clinicRepository;
    }

    public PersonModel registeredPerson(String name,String email, String password,int age, String gender){
        if(email == null && password == null){
            return null;
        }else{
            if(personRepository.findByEmail(email).isPresent()){
                System.out.println("duplicate");
                return null;
            }
            PersonModel personModel = new PersonModel();
            personModel.setName(name);
            personModel.setPassword(password);
            personModel.setEmail(email);
            personModel.setAge(age);
            personModel.setGender(gender);
            return personRepository.save(personModel);
        }
    }

    public static PersonModel authenticate(String email, String password){
        System.out.println("--------------------------"+personRepository.findByEmailAndPassword(email,password));
        return personRepository.findByEmailAndPassword(email,password).orElse(null);
    }

    public ClinicModel registeredClinic(String name, String email, String description, String address, String password){
        if(email == null && password == null){
            return null;
        }else{
            if(clinicRepository.findByEmail(email).isPresent()){
                System.out.println("duplicate");
                return null;
            }
            ClinicModel clinicModel = new ClinicModel();
            clinicModel.setName(name);
            clinicModel.setEmail(email);
            clinicModel.setAddress(address);
            clinicModel.setDescription(description);
            clinicModel.setPassword(password);
            return clinicRepository.save(clinicModel);

        }
    }
    public static ClinicModel authenticateClinic(String email, String password){
        return clinicRepository.findByEmailAndPassword(email,password).orElse(null);
    }
}
