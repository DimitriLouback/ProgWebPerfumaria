package br.edu.iff.ccc.bsi.perfumaria.repository;

import br.edu.iff.ccc.bsi.perfumaria.entities.Carrinho;
import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query("SELECT c FROM Carrinho c WHERE c.cliente = :cliente")
    List<Carrinho> findByCliente(Cliente cliente);

    Carrinho findByClienteId(Long clienteId);

}