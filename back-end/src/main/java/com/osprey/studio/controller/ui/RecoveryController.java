package com.osprey.studio.controller.ui;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Controller
public class RecoveryController {

    @Autowired
    private UserService userService;


    @GetMapping("/recovery")
    public String reminder() {
        return "recovery";
    }

    @PostMapping("/recovery")
    public String recovery(
            @RequestParam String email,
            Model model
    ) throws InterruptedException {
        if (StringUtils.isEmpty(email)){
            model.addAttribute("emailRecoveryError", "Email is not correct");
            return "/recovery";
        }

        if (userService.findByEmail(email).isPresent()){
            User user = userService.findByEmail(email).get();
            userService.sendMessagePasswordRecovery(email, user);
            model.addAttribute
                    ("sendMessageRecovery", "We send new password on your email. " +
                            "After 5 seconds you will be transferred to the login page....");
            // Thread.sleep(5000);
            } else {
                model.addAttribute("userRecoveryError", "This email not in base.");
                return "/recovery";
            }

        return "redirect:/login";
    }
}
