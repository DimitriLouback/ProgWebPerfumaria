package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "Cliente não pode ser nulo")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "carrinho_perfumes",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "perfume_id")
    )
    private List<Perfume> perfumes;

    @Min(value = 0, message = "O valor total não pode ser negativo")
    @Column(name = "valor_total")
    private double valorTotal;

    public Carrinho() {
        this.perfumes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Perfume> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(List<Perfume> perfumes) {
        this.perfumes = perfumes;
        calcularValorTotal(); // Atualiza o valor total ao adicionar perfumes
    }

    public double getValorTotal() {
        return valorTotal;
    }


    public void calcularValorTotal() {
        this.valorTotal = perfumes.stream()
                .mapToDouble(Perfume::getPreco)
                .sum();
    }
}