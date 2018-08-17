package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller

public class RegistrationController {


    @Autowired
    public UserService userService;

    public BCryptPasswordEncoder passwordEncoder;



    @GetMapping("/registration")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(@RequestParam("confirmpassword") String confirmpassword, User userregistration, BindingResult bindingResult, Model model) {

        // boolean isConfirmEmpty = StringUtils.isEmpty(confirmpassword);
        System.out.println("Hello");
        if (userregistration.getPassword() == null) {
            model.addAttribute("passwordError", "Password cannot be empty!");

        }

        if (!userregistration.getPassword().equals(confirmpassword)) {
            model.addAttribute("confirmPasswordError", "Password are different");
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.addAttribute(errors);
            return "registration"; }


//        if (userService.findByEmail(userregistration.getEmail()) != null) {
//            System.out.print(userService.findByEmail(userregistration.getEmail()));
//            model.addAttribute("emailErorr", "Email exists");
//            return "registration";
//        }


        userregistration.setLastName("Igor");
        userregistration.setFirstName("Ten");
        userregistration.setId(7);
        userregistration.setActive(true);
        userregistration.setState(State.ACTIVE);
        userregistration.setRoles(Collections.singleton(Role.ADMIN));
        System.out.print(userregistration);

        userService.create(userregistration);

        return "redirect://login";

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
