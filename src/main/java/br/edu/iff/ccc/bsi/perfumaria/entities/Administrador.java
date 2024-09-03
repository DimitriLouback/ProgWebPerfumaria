package br.edu.iff.ccc.bsi.perfumaria.entities;
import jakarta.persistence.*;


@Entity
public class Administrador extends Usuario {

    public Administrador() {

    }

    @Column(name = "senha_acesso")
    private String senhaAcesso;


    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

}
