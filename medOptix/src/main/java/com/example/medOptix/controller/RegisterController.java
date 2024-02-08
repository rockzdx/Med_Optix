package com.example.medOptix.controller;

import com.example.medOptix.model.ClinicModel;
import com.example.medOptix.model.PersonModel;
import com.example.medOptix.service.RegistrationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {
    private final RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new PersonModel());
        return "registration_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute PersonModel personModel,Model model){
        System.out.println("register_request: "+personModel);
        PersonModel registeredPerson = registrationService.registeredPerson(personModel.getName(),personModel.getEmail(),personModel.getPassword(),personModel.getAge(),personModel.getGender());
        return registeredPerson == null ? "error_page" : "redirect:/login";
    }

}