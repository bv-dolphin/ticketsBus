package com.osprey.studio.controller.ui.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/" + LoginUiController.ROOT_PATH)
public class LoginUiController {

    public static final String ROOT_PATH = "public";

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {

        if (authentication != null) {
            return "redirect:/public/main";
        }

        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }

        if (request.getParameterMap().containsKey("logout")) {
            model.addAttribute("logout", true);
        }
        return "login";
    }


}
