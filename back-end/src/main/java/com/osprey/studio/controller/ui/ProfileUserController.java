package com.osprey.studio.controller.ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileUserController {


    @GetMapping("/profile")
//    public String getProfilePage(ModelMap model, Authentication authentication) {
//        if (authentication == null) {
//            return "redirect:/login";
//        }
//        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
//        UserDto user = from(details.getUser());
//        model.addAttribute("user", user);
    public String profile() {
        return "profile";
    }
}
