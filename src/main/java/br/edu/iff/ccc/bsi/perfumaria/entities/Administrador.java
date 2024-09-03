package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Administrador(long id) {
        this.id= id;

    }

    public Administrador() {

    }

    @Column(name = "nome")
    private String nome;

    @Column(unique= true, name = "CPF")
    private String CPF;

    @Column(name = "celular")
    private String celular;

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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
