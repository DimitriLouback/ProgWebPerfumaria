package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
public class Perfume implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Perfume(long id) {
        this.id = id;
    }

    public Perfume() {
    }

    @NotEmpty(message = "Nome do perfume não pode estar vazio")
    @Size(min = 3, max = 50, message = "Nome do perfume deve ter entre 3 e 50 caracteres")
    @Column(name = "nome")
    private String nome;

    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
    @Column(name = "preco")
    private float preco;

    @Positive(message = "Quantidade em estoque deve ser positiva")
    @Column(name = "quantidade_em_estoque")
    private int quantidadeEmEstoque;

    @NotEmpty(message = "Fragrância não pode estar vazia")
    @Column(name = "fragrancia")
    private String fragrancia;

    @NotEmpty(message = "Marca não pode estar vazia")
    @Column(name = "marca")
    private String marca;

    @Positive(message = "Volume deve ser positivo")
    @Column(name = "volume")
    private int volume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


}
