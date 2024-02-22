package com.example.medOptix.service;

import com.example.medOptix.model.PersonModel;
import com.example.medOptix.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PersonModel personModel = personRepository.findByEmail(username);

        if(personModel == null){
            throw new UsernameNotFoundException("user not found!!");
        }

        return new CustomUserDetails(personModel);
    }
}
