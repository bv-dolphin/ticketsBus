package com.osprey.studio.controller.ui;


import com.osprey.studio.domain.entities.BusFlight;
import com.osprey.studio.service.BusFlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/" + MainController.ROOT_PATH)
public class MainController {

    static final String ROOT_PATH = "public";

    public final BusFlightService busFlightService;

    public MainController(BusFlightService busFlightService) {
        this.busFlightService = busFlightService;
    }

    @GetMapping ("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/main/search")

    public String search (@RequestParam String departure,
                          @RequestParam String arrival,
                          Model model) {
        List<BusFlight> busflights;
//
//        if (busflights != null) {
//            model.addAttribute("busflights", "every thing ok");
//        } else {
//            model.addAttribute("busflightsError", "no flights");
//        }
        if (departure !=null && !departure.isEmpty() || arrival !=null && !arrival.isEmpty() ) {
            model.addAttribute("busflights", busFlightService.search(departure, arrival));
        }

        return "main";
    }

    @GetMapping("/info")
    public String info() {return "info"; }

    @GetMapping("/ticket")
    public String ticket() {return "ticket"; }

    @GetMapping("/contacts")
    public String contacts() {return "contacts"; }
}
