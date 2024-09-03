package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Usuario(long id) {
        this.id= id;

    }

    public Usuario() {

    }

    @Column(name = "nome")
    private String username;

    @Column(name = "senha")
    private String senha;

    @Column(unique= true, name = "email")
    private String email;

    @Column(name = "CPF")
    private String CPF;

    @Column(name = "celular")
    private String celular;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
