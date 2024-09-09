package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Administrador;
import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import br.edu.iff.ccc.bsi.perfumaria.entities.Endereco;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    public UsuarioRepository UserRep;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Olá Mundo, agora sei dar comando no Spring");

//        Endereco end1 = new Endereco();
//        end1.setCidade("Campos");
//        end1.setBairro("Centro");
//        end1.setCEP("280-555");
//        end1.setRua("28 de março");
//
//        Administrador user1 = new Administrador();
//        Cliente user2 = new Cliente();
//
//        user1.setUsername("Amanda");
//        user1.setSenhaAcesso("12345");
//
//        user2.setUsername("Carol");
//        user2.setRG("1334455");
//        user2.setEndereco(end1);
//        user2.setGenero("feminino");
//        user2.setCPF("19202920");
//
//        UserRep.save(user1);
//        UserRep.save(user2);
//
//        Usuario usuarioEncontrado = UserRep.findByUsername("Carol");





    }

}