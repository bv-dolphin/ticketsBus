package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.forms.UserRegistration;

import com.osprey.studio.service.security.SignUpService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class RegistrationController {



    private final SignUpService service;

    public RegistrationController(SignUpService service) {
        this.service = service;
    }

    @GetMapping("/registration")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String signUp(UserRegistration userRegistrationForm) {
        service.signUp(userRegistrationForm);
        return "redirect:/login";
    }

    @GetMapping("/recovery")
    public String reminder() {
        return "recovery";
    }


    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        if (authentication != null) {
            return "redirect:/";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }

}
