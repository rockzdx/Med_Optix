package com.example.medOptix.service;

import com.example.medOptix.model.PersonModel;
import com.example.medOptix.repository.PersonRepository;

public class RegistrationService {
    private final PersonRepository personRepository;

    public RegistrationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonModel registeredPerson(String name,String email, String password,int age, String gender){
        if(name == null && password == null){
            return null;
        }else{
            if(personRepository.findByEmail(email).isPresent()){
                System.out.println("duplicate");
                return null;
            }
            PersonModel personModel = new PersonModel();
            personModel.setName(email);
            personModel.setPassword(password);
            personModel.setEmail(email);
            personModel.setAge(age);
            personModel.setGender(gender);
            return personRepository.save(personModel);
        }
    }
    public PersonModel authenticate(String email,String password){
        return personRepository.findByEmailAndPassword(email,password).orElse(null);
    }
}
