package com.osprey.studio.controller.ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/" + MainController.ROOT_PATH)
public class MainController {

    public static final String ROOT_PATH = "public";

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}