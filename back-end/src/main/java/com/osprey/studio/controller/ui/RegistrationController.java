package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.service.MailService;
import com.osprey.studio.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.osprey.studio.service.security.SignUpService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Controller

public class RegistrationController {



    public final SignUpService singlUpService;
    public final UserService userService;



    public RegistrationController(SignUpService singlUpService, MailService mailService, UserService userService) {
        this.singlUpService = singlUpService;

        this.userService = userService;
    }


    @GetMapping("/registration")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute UserRegistration user, BindingResult bindingResult, Model model) {


        if (user.getPassword() == null) {
            model.addAttribute("passwordError", "Password cannot be empty!");

        }

        if (!user.getPassword().equals(user.getConfirmpassword())) {
            model.addAttribute("confirmPasswordError", "Password are different");
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration"; }


            //заходит в метод Sign Up // делаает там проверку на существование юзера
        if (!singlUpService.signUp(user)) {
            model.addAttribute("emailError", "Email exists");
            return "registration";

        }
        userService.sendMessage(user);

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(Model model, @PathVariable String code) {

        boolean isActivated = userService.activateUser(code);
        User user = new User();

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
            user.setRoles(Collections.singleton(Role.USER));

        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }



        return "login";
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
