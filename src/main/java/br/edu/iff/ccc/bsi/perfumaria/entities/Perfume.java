package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;

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

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private float preco;

    @Column(name = "quantidade_em_estoque")
    private int quantidadeEmEstoque;

    @Column(name = "fragrancia")
    private String fragrancia;

    @Column(name = "marca")
    private String marca;

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
