package br.edu.iff.ccc.bsi.perfumaria.controller.view;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeViewController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping("/home")
    public String listarPerfumes(Model model) {
        List<Perfume> perfumes = perfumeService.listarPerfumes();
        model.addAttribute("perfumes", perfumes);
        return "home";
    }
}