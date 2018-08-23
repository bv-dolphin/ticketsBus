package com.osprey.studio.controller.ui;


import com.osprey.studio.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/" + MainController.ROOT_PATH)
public class MainController {

    static final String ROOT_PATH = "public";

    public final CityService cityService;

    public MainController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/main/search")
    public String search (@RequestParam("s") String s, Model model) {
        if (s.equals("")) {
            return "redirect:/main";
        }
        model.addAttribute("", cityService.search(s));
        return "main";
    }

    @PostMapping("/main")

    @GetMapping("/info")
    public String info() {return "info"; }

    @GetMapping("/ticket")
    public String ticket() {return "ticket"; }

    @GetMapping("/contacts")
    public String contacts() {return "contacts"; }
}
