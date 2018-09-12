package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.service.MailService;
import com.osprey.studio.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.osprey.studio.service.security.SignUpService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller

public class RegistrationController {



    public final SignUpService signUpService;
    public final UserService userService;



    public RegistrationController(SignUpService singUpService, MailService mailService, UserService userService) {
        this.signUpService = singUpService;

        this.userService = userService;
    }


    @GetMapping("/registration")
    public String getSignUpPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(
            @RequestParam("confirmPassword") String passwordConfirm,
            @Valid UserRegistration user,
                             BindingResult bindingResult,
                             Model model)
    {
        if (StringUtils.isEmpty(passwordConfirm)){
            model.addAttribute("confirmPasswordError", "Confirm password cannot be empty");
        }

        assert user.getPassword() != null;
        if (user.getPassword() != null & !user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("confirmPasswordError", "Password are different");
            return "registration";
        }

        if (!signUpService.signUp(user)) {
            model.addAttribute("emailError", "Email exists");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        model.addAttribute
                ("sendMessageRegistration", "We send activation code on your email.");
        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(Model model, @PathVariable String code) {

        boolean isActivated = userService.activateUser(code);



        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");


        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
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
