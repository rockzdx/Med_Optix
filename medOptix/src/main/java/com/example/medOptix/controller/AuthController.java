package com.example.medOptix.controller;

import com.example.medOptix.model.ClinicModel;
import com.example.medOptix.model.PersonModel;
import com.example.medOptix.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/")
    public ModelAndView greetings(ModelAndView modelAndView){
        modelAndView.setViewName("welcome_page");
        return modelAndView;
    }

    @GetMapping("/userLogReg")
    public ModelAndView user(ModelAndView modelAndView){
        modelAndView.setViewName("user_logreg_page");
        return modelAndView;
    }

    @GetMapping("/clinicLogReg")
    public ModelAndView clinic(ModelAndView modelAndView){
        modelAndView.setViewName("clinic_logreg_page");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(ModelAndView modelAndView,PersonModel personModel){
        modelAndView.addObject("person",personModel);
        modelAndView.setViewName("registration_page");
        return modelAndView;
    }
    @PostMapping("/register")
    public String register(PersonModel personModel){
        System.out.println("register_request: "+personModel);
        PersonModel registeredPerson = authService.registeredPerson(personModel.getName(),personModel.getEmail(),personModel.getPassword(),personModel.getAge(),personModel.getGender());
        return registeredPerson == null ? "error_page" : "redirect:/login";
    }
    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView modelAndView, PersonModel personModel){
        modelAndView.addObject("person",personModel);
        modelAndView.setViewName("login_page");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login (PersonModel personModel){
        System.out.println("login_request: "+ personModel);
        PersonModel authenticated = AuthService.authenticate(personModel.getEmail(),personModel.getPassword());
        if(authenticated != null){
            return "user_home_page";
        }else{
            return "error_page";
        }
    }
    @GetMapping("/clinicRegister")
    public ModelAndView getClinicRegPage(ModelAndView modelAndView, ClinicModel clinicModel){
        modelAndView.addObject("clinic",clinicModel);
        modelAndView.setViewName("clinic_reg_page");
        return modelAndView;
    }

    @PostMapping("/clinicRegister")
    public String clinicRegister(ClinicModel clinicModel,PersonModel personModel){
        System.out.println("ClinicRegister_request: "+clinicModel);
        ClinicModel registeredClinic = authService.registeredClinic(clinicModel.getClinicName(),clinicModel.getEmail(),clinicModel.getDescription(),clinicModel.getAddress(),clinicModel.getPassword(),personModel.getAge(),personModel.getName(),personModel.getGender());
        return registeredClinic == null ? "error_page" : "redirect:/clinicLogin";
    }

    @GetMapping("/clinicLogin")
    public ModelAndView getClinicLoginPage(ModelAndView modelAndView, ClinicModel clinicModel){
        modelAndView.addObject("clinic",clinicModel);
        modelAndView.setViewName("clinic_login_page");
        return modelAndView;
    }

    @PostMapping("/clinicLogin")
    public String ClinicLogin (ClinicModel clinicModel){
        System.out.println("ClinicLogin_request: "+ clinicModel);
        ClinicModel authenticated = AuthService.authenticateClinic(clinicModel.getEmail(),clinicModel.getPassword());
        if(authenticated != null){
            return "clinic_dashboard";
        }else{
            return "error_page";
        }
    }

}