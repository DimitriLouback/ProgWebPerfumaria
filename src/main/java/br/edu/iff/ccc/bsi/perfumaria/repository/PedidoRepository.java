package br.edu.iff.ccc.bsi.perfumaria.repository;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido")
    List<Pedido> findByDataPedido(Date dataPedido);
    
}