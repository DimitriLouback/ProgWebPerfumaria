package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pagamento;
import br.edu.iff.ccc.bsi.perfumaria.repository.PagamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento inserirPagamento(Pagamento pagamento) {
        if (!List.of("Pendente", "Concluído", "Cancelado").contains(pagamento.getStatusPagamento())) {
            throw new IllegalArgumentException("Status de pagamento inválido");
        }
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public void removerPagamentoPorId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public Pagamento atualizarPagamento(Long id, Pagamento pagamentoAtualizado) {
        Optional<Pagamento> pagamentoExistente = pagamentoRepository.findById(id);

        if (pagamentoExistente.isPresent()) {
            Pagamento pagamento = pagamentoExistente.get();


            pagamento.setMetodoPagamento(pagamentoAtualizado.getMetodoPagamento());
            pagamento.setStatusPagamento(pagamentoAtualizado.getStatusPagamento());
            pagamento.setCarrinho(pagamentoAtualizado.getCarrinho());


            return pagamentoRepository.save(pagamento);
        } else {
            throw new RuntimeException("Pagamento com ID " + id + " não encontrado");
        }
    }
}