package com.osprey.studio.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultPage {

    @GetMapping("/")
    public String defaultPage(){
        return "redirect:/public/main";
    }
}
