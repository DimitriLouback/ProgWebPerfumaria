package br.edu.iff.ccc.bsi.perfumaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Administrador extends Usuario {

    public Administrador() {

    }
    @NotBlank(message = "Nível de acesso não pode ser vazio")
    @Column(name = "nivel_acesso")
    private String nivelAcesso;

    @NotBlank(message = "Área responsável não pode ser vazia")
    @Column(name = "area_responsavel")
    private String areaResponsavel;

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    public void setAreaResponsavel(String areaResponsavel) {
        this.areaResponsavel = areaResponsavel;
    }
}