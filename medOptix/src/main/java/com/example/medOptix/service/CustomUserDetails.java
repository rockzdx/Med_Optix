package com.example.medOptix.service;

import com.example.medOptix.model.PersonModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

class CustomUserDetails implements UserDetails{

    private PersonModel personModel;

    public CustomUserDetails(PersonModel personModel) {
        this.personModel = personModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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