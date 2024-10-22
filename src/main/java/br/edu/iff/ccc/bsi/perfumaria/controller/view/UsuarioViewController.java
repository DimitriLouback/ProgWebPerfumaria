package br.edu.iff.ccc.bsi.perfumaria.controller.view;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioViewController {

    @Autowired
    private UsuarioService usuarioService;

    // Exibe a página de listagem de usuários
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

    // Exibe a página de formulário para criar um novo usuário
    @GetMapping("/novo")
    public String exibirFormUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());  // Atributo para preencher o formulário
        return "novoUsuario";
    }

    // Processa o formulário de criação de usuário
    @PostMapping
    public String salvarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "novoUsuario";  // Retorna ao formulário se houver erros
        }
        usuarioService.inserirUsuario(usuario);  // Salva o usuário se os dados forem válidos
        return "redirect:/usuario";  // Redireciona para a lista de usuários
    }

    // Exibe a página de edição de um usuário existente
    @GetMapping("/edit/{id}")
    public String exibirFormEdicao(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "editarUsuario";
        }
        return "redirect:/usuario";  // Se o usuário não for encontrado, redireciona para a listagem
    }

    // Processa a edição de um usuário
    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable Long id, @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novoUsuario";  // Retorna ao formulário se houver erros
        }
        usuarioService.atualizarUsuario(id, usuario);
        return "redirect:/usuario";  // Redireciona para a lista de usuários
    }

    // Remove um usuário pelo ID
    @GetMapping("/delete/{id}")
    public String removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuarioPorId(id);
        return "redirect:/usuario";  // Redireciona para a lista após a remoção
    }
}