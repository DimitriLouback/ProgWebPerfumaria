package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NotNull(message = "O carrinho não pode ser nulo")
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @OneToOne
    @NotNull(message = "O pagamento não pode ser nulo")
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    @NotNull(message = "A data do pedido não pode ser nula")
    @Past(message = "A data do pedido deve ser no passado")
    @Column(name = "data_pedido")
    private Date dataPedido;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
}