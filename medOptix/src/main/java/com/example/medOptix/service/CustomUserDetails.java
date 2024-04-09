package com.example.medOptix.service;

import com.example.medOptix.model.EntityModel;
import com.example.medOptix.model.EntityRoleMapModel;
import com.example.medOptix.model.PersonModel;
import com.example.medOptix.model.RolesModel;
import com.example.medOptix.repository.EntityRepository;
import com.example.medOptix.repository.EntityRoleMapRepository;
import com.example.medOptix.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


class CustomUserDetails implements UserDetails{

    public GrantedAuthority getGrantedAuthority() {
        return grantedAuthority;
    }

    public void setGrantedAuthority(GrantedAuthority grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }

    private GrantedAuthority grantedAuthority;

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    private PersonModel personModel;
    private EntityModel entityModel;
    private EntityRoleMapModel entityRoleMapModel;




//    public CustomUserDetails(PersonModel personModel) {
//        this.personModel = personModel;
//    }

    public CustomUserDetails(PersonModel personModel, EntityModel entityModel, EntityRoleMapModel entityRoleMapModel) {
        this.personModel = personModel;
        this.entityModel = entityModel;
        this.entityRoleMapModel = entityRoleMapModel;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Long personId = personModel.getPersonId();



        Long entityId = entityModel.getEntityId();



        RolesModel rolesModel = entityRoleMapModel.getRolesModel();

        System.out.println(rolesModel.getRoleName() + "line 77 custom user details");

        authorities.add(new SimpleGrantedAuthority(rolesModel.getRoleName()));

        return authorities;
    }




    @Override
    public String getPassword() {

        System.out.println(personModel.getPassword());
        return personModel.getPassword();
    }

    @Override
    public String getUsername() {
        return personModel.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}