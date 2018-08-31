package com.osprey.studio.controller.ui.security;

import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.service.security.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.osprey.studio.domain.transfer.UserDto.from;

@Controller
@RequestMapping("/" + SignUpUiController.ROOT_PATH)
public class SignUpUiController {

    public static final String ROOT_PATH = "public";

    private final SignUpService service;

    public SignUpUiController(SignUpService service) {
        this.service = service;
    }

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserRegistration userRegistration) {

        service.signUp(userRegistration);

        return "redirect:/login";
    }

}
