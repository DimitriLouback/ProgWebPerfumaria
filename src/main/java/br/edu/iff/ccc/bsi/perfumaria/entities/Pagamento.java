package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @Column(name = "metodo_pagamento")
    @NotEmpty
    private String metodoPagamento;

    @NotEmpty
    @Column(name = "status_pagamento")
    private String statusPagamento;

    public Pagamento() {
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

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}