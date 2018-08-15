package com.osprey.studio.controller.ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/" + MainController.ROOT_PATH)
public class MainController {

    static final String ROOT_PATH = "public";

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/info")
    public String info() {return "info"; }

    @GetMapping("/ticket")
    public String ticket() {return "ticket"; }

    @GetMapping("/contacts")
    public String contacts() {return "contacts"; }
}
