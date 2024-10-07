package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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



    @NotEmpty(message = "Nome de usuário não pode estar vazio")
    @Size(min = 3, max = 50, message = "Nome de usuário deve ter entre 3 e 50 caracteres")
    @Column(name = "nome")
    private String username;


    @NotEmpty(message = "Senha não pode estar vazia")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    @Column(name = "senha")
    private String senha;

    @NotEmpty(message = "Email não pode estar vazio")
    @Email(message = "Email deve ser válido")
    @Column(unique= true, name = "email")
    private String email;


    @NotEmpty(message = "CPF não pode estar vazio")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
    @Column(name = "CPF")
    private String CPF;

    @NotEmpty(message = "Número de celular não pode estar vazio")
    @Pattern(regexp = "\\d{10,11}", message = "Número de celular deve ter 10 ou 11 dígitos")
    @Column(name = "celular")
    private String celular;

    @Embedded
    private Endereco endereco;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
