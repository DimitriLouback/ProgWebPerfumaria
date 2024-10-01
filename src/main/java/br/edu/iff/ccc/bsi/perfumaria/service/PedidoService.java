package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import br.edu.iff.ccc.bsi.perfumaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido inserirPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizarPedido(Long id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public void removerPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }
}