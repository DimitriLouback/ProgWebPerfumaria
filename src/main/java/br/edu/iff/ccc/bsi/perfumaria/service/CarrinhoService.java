package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Carrinho;
import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.CarrinhoRepository;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private PerfumeRepository perfumeRepository;


    public Carrinho inserirCarrinho(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }


    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }


    public Carrinho buscarPorCliente(Long clienteId) {
        return carrinhoRepository.findByClienteId(clienteId);
    }


    public List<Carrinho> listarCarrinhos() {
        return carrinhoRepository.findAll();
    }


    public void removerCarrinhoPorId(Long id) {
        carrinhoRepository.deleteById(id);
    }

    @Transactional
    public Carrinho adicionarPerfume(Long carrinhoId, Long perfumeId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado"));

        Perfume perfume = perfumeRepository.findById(perfumeId)
                .orElseThrow(() -> new IllegalArgumentException("Perfume não encontrado"));

        carrinho.getPerfumes().add(perfume);
        carrinho.calcularValorTotal();
        return carrinhoRepository.save(carrinho);
    }


    public Carrinho removerPerfume(Long carrinhoId, Long perfumeId) {
        Optional<Carrinho> optionalCarrinho = carrinhoRepository.findById(carrinhoId);
        Optional<Perfume> optionalPerfume = perfumeRepository.findById(perfumeId);

        if (optionalCarrinho.isPresent() && optionalPerfume.isPresent()) {
            Carrinho carrinho = optionalCarrinho.get();
            Perfume perfume = optionalPerfume.get();
            carrinho.getPerfumes().remove(perfume);
            carrinho.setPerfumes(carrinho.getPerfumes());
            return carrinhoRepository.save(carrinho);
        }
        return null;
    }
}
