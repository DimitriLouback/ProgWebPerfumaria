package br.edu.iff.ccc.bsi.perfumaria.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Entity
    public class Cliente extends Usuario {

        public Cliente() {

        }

        @Column(name = "data_nascimento")
        private Date dataNascimento;

        @Column(name = "genero")
        private String genero;

        @Column(name = "RG")
        private String RG;


        public Date getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getRG() {
            return RG;
        }

        public void setRG(String RG) {
            this.RG = RG;
        }
    }

