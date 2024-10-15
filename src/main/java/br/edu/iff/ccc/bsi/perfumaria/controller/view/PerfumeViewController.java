package br.edu.iff.ccc.bsi.perfumaria.controller.view;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfume")
public class PerfumeViewController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public String listarPerfumes(Model model) {
        model.addAttribute("perfumes", perfumeService.listarPerfumes());
        return "perfumes";
    }


    @GetMapping("/novo")
    public String novoFormPerfume(Model model) {
        model.addAttribute("perfume", new Perfume());
        return "novoPerfume";
    }

    @PostMapping
    public String salvarPerfume(@Valid @ModelAttribute("perfume") Perfume perfume, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("perfume", perfume);
            return "novoPerfume";
        }
        perfumeService.inserirPerfume(perfume);
        return "redirect:/perfume";
    }

    @GetMapping("/edit/{id}")
    public String editarPerfume(@PathVariable Long id, Model model) {
        Perfume perfume = perfumeService.buscarPorId(id);
        model.addAttribute("perfume", perfume);
        return "editarPerfume";
    }

    @PostMapping("/update/{id}")
    public String updatePerfume(@PathVariable Long id, @ModelAttribute Perfume perfume) {
        Perfume perfumeExistente = perfumeService.buscarPorId(id);
        perfumeExistente.setNome(perfume.getNome());
        perfumeExistente.setPreco(perfume.getPreco());
        perfumeExistente.setFragrancia(perfume.getFragrancia());
        perfumeExistente.setQuantidadeEmEstoque(perfume.getQuantidadeEmEstoque());
        perfumeExistente.setMarca(perfume.getMarca());
        perfumeExistente.setVolume(perfume.getVolume());
        perfumeService.inserirPerfume(perfumeExistente);
        return "redirect:/perfume";
    }
    @GetMapping("/delete/{id}")
    public String deletarPerfume(@PathVariable Long id) {
       perfumeService.removerPerfumePorId(id);
        return "redirect:/perfume";
    }

}
