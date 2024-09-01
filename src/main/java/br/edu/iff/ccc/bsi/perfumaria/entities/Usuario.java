package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_usuarios")
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

@Column(name = "username")
private String username;

@Column(unique= true, name = "email")
private String email;

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

}
