package com.example.medOptix.service;

import com.example.medOptix.model.EntityModel;
import com.example.medOptix.model.EntityRoleMapModel;
import com.example.medOptix.model.PersonModel;
import com.example.medOptix.model.RolesModel;
import com.example.medOptix.repository.EntityRepository;
import com.example.medOptix.repository.EntityRoleMapRepository;
import com.example.medOptix.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private EntityRoleMapRepository entityRoleMapRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PersonModel personModel = personRepository.findByEmail(username);

        System.out.println(" testing 92380823974823894728378787837878378837837878" + personModel.getName());




        if(personModel == null){
            throw new UsernameNotFoundException("user not found!!");
        }

        EntityModel entityModel = entityRepository.findByEntityId(personModel.getEntity().getEntityId());

        System.out.println(personModel.getName());

        Long entityId = entityModel.getEntityId();

        EntityRoleMapModel entityRoleMapModel = entityRoleMapRepository.findByEntityModel(entityModel);

        RolesModel rolesModel = entityRoleMapModel.getRolesModel();

        return new CustomUserDetails(personModel, entityModel, entityRoleMapModel);

    }
}
