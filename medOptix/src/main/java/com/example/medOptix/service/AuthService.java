package com.example.medOptix.service;

import com.example.medOptix.model.*;
import com.example.medOptix.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private EntityRepository entityRepository;
    private RolesRepository rolesRepository;
    private static PersonRepository personRepository;
    private static ClinicRepository clinicRepository;
    private EntityRoleMapRepository entityRoleMapRepository;
    public AuthService(EntityRepository entityRepository, RolesRepository rolesRepository, PersonRepository personRepository, ClinicRepository clinicRepository, EntityRoleMapRepository entityRoleMapRepository) {
        this.entityRepository = entityRepository;
        this.rolesRepository = rolesRepository;
        AuthService.personRepository = personRepository;
        AuthService.clinicRepository = clinicRepository;
        this.entityRoleMapRepository = entityRoleMapRepository;
    }

    public PersonModel registeredPerson(String name,String email, String password,int age, String gender){
        if(email == null && password == null){
            return null;
        }else{
            if(personRepository.findByEmail(email) != null){
                System.out.println("duplicate");
                return null;
            }
            EntityModel entityModel = new EntityModel();
            PersonModel personModel = new PersonModel();
            RolesModel rolesModel = new RolesModel();
            EntityRoleMapModel entityRoleMapModel = new EntityRoleMapModel();
            rolesModel.setRoleName("person");
            personModel.setName(name);
            personModel.setPassword(password);
            personModel.setEmail(email);
            personModel.setAge(age);
            personModel.setGender(gender);

            entityModel.setPerson(personModel);
            entityRoleMapModel.setEntityModel(entityModel);
            entityRoleMapModel.setRolesModel(rolesModel);

            personRepository.save(personModel);
            entityRepository.save(entityModel);
            rolesRepository.save(rolesModel);
            entityRoleMapRepository.save(entityRoleMapModel);
            return personModel;
        }
    }

    public static PersonModel authenticate(String email, String password){
        System.out.println("--------------------------"+personRepository.findByEmailAndPassword(email,password));
        return personRepository.findByEmailAndPassword(email,password);
    }

    public ClinicModel registeredClinic(String clinicName, String email, String description, String address, String password,Integer age,String name,String gender){
        if(email == null && password == null){
            return null;
        }else{
            if(clinicRepository.findByEmail(email).isPresent()){
                System.out.println("duplicate");
                return null;
            }
            EntityModel entityModel = new EntityModel();
            ClinicModel clinicModel = new ClinicModel();
            PersonModel personModel = new PersonModel();
            RolesModel rolesModel = new RolesModel();
            EntityRoleMapModel roleMapModel = new EntityRoleMapModel();
            rolesModel.setRoleName("clinicAdmin");
            clinicModel.setClinicName(clinicName);
            clinicModel.setEmail(email);
            personModel.setEmail(email);
            personModel.setPassword(password);
            clinicModel.setAddress(address);
            clinicModel.setDescription(description);
            clinicModel.setPassword(password);
            personModel.setName(name);
            personModel.setAge(age);
            personModel.setGender(gender);

            roleMapModel.setRolesModel(rolesModel);
            roleMapModel.setEntityModel(entityModel);
            entityModel.setPerson(personModel);
            entityModel.setClinic(clinicModel);

            personRepository.save(personModel);
            clinicRepository.save(clinicModel);
            entityRepository.save(entityModel);
            rolesRepository.save(rolesModel);
            entityRoleMapRepository.save(roleMapModel);
            return clinicModel;
        }
    }
    public static ClinicModel authenticateClinic(String email, String password){
        return clinicRepository.findByEmailAndPassword(email,password).orElse(null);
    }
}
