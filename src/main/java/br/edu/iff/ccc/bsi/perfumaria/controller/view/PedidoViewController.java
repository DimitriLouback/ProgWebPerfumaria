package br.edu.iff.ccc.bsi.perfumaria.controller.view;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import br.edu.iff.ccc.bsi.perfumaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoViewController {

    @Autowired
    private PedidoService pedidoService;

    // Listar pedidos
    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        model.addAttribute("pedidos", pedidos);
        return "listarPedidos";
    }

    // Exibir formulário para adicionar novo pedido
    @GetMapping("/novo")
    public String exibirFormularioNovoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "novoPedido";
    }

    // Salvar novo pedido
    @PostMapping
    public String salvarPedido(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pedido", pedido);
            return "novoPedido";
        }
        pedidoService.inserirPedido(pedido);
        return "redirect:/pedidos";
    }

    // Exibir formulário para editar pedido
    @GetMapping("/edit/{id}")
    public String exibirFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPorId(id);
        model.addAttribute("pedido", pedido);
        return "editarPedido";
    }

    // Atualizar pedido
    @PostMapping("/update/{id}")
    public String atualizarPedido(@PathVariable Long id,@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editarPedido";
        }
        pedidoService.atualizarPedido(id, pedido);
        return "redirect:/pedidos";
    }

    // Remover pedido
    @GetMapping("/delete/{id}")
    public String removerPedido(@PathVariable Long id) {
        pedidoService.removerPedidoPorId(id);
        return "redirect:/pedidos";
    }
}
