package br.edu.iff.ccc.bsi.perfumaria.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.io.Serializable;
import java.util.Date;

    @Entity
    public class Cliente extends Usuario {

        public Cliente() {

        }

        @OneToOne(mappedBy = "cliente")
        private Carrinho carrinho;

        @NotNull(message = "Data de nascimento não pode ser nula")
        @Past(message = "Data de nascimento deve ser no passado")
        @Column(name = "data_nascimento")
        private Date dataNascimento;

        @NotNull(message = "Data de cadastro não pode ser nula")
        @Past(message = "Data de cadastro deve ser uma data no passado")
        @Column(name = "data_cadastro")
        private Date dataCadastro;


        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public Date getDataCadastro() {
            return dataCadastro;
        }

        public void setDataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
        }
    }
