package br.edu.iff.ccc.bsi.perfumaria.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewMainController {

    @GetMapping
    public String getHome() {
        return "home";
    }

}



