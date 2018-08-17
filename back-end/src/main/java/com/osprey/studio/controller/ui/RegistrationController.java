package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller

public class RegistrationController {


    @Autowired
    public UserService userService;


    @GetMapping("/registration")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser
            (@RequestParam("confirmPassword") String confirmPassword,
            @Valid User user,
             BindingResult bindingResult,
             Model model) {
        if (user.getPassword() != null, && !user.getPassword().equals())
    }

    {

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
