package com.example.medOptix.controller;

import com.example.medOptix.service.LoginService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){this.loginService=loginService;}
}
