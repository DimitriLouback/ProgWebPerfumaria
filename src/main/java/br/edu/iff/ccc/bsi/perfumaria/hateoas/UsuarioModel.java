package br.edu.iff.ccc.bsi.perfumaria.hateoas;

import org.springframework.hateoas.RepresentationModel;

public class UsuarioModel extends RepresentationModel<UsuarioModel> {

    long id;
    String username;
    String senha;
    String email;
    String CPF;
    String celular;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
