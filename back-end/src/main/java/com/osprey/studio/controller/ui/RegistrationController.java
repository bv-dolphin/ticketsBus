package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.forms.UserRegistration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osprey.studio.service.security.SignUpService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller

public class RegistrationController {



    public final SignUpService singlUpService;

    public RegistrationController(SignUpService singlUpService) {
        this.singlUpService = singlUpService;
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
