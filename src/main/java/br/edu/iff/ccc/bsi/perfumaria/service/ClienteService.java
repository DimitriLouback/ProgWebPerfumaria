package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.ClienteRepository;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente inserirCliente(Cliente cliente) {
        return (Cliente) usuarioRepository.save(cliente);
    }


    public Cliente buscarPorId(Long id) {
        return (Cliente) usuarioRepository.findById(id).orElse(null);
    }


    public Cliente buscarPorNome(String username) {
        List<Usuario> usuarios = usuarioRepository.findByUsername(username);

        return usuarios.stream()
                .filter(usuario -> usuario instanceof Cliente)
                .map(usuario -> (Cliente) usuario)
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarClientes() {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario instanceof Cliente)
                .map(usuario -> (Cliente) usuario)
                .collect(Collectors.toList());
    }

    public void removerClientePorId(Long id) {
        usuarioRepository.deleteById(id);
    }


    public List<Cliente> buscarPorDataNascimento(Date dataNascimento) {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario instanceof Cliente)
                .map(usuario -> (Cliente) usuario)
                .filter(cliente -> cliente.getDataNascimento().equals(dataNascimento))
                .collect(Collectors.toList());
    }

    public List<Cliente> buscarPorDataCadastro(Date dataCadastro) {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario instanceof Cliente)
                .map(usuario -> (Cliente) usuario)
                .filter(cliente -> cliente.getDataCadastro().equals(dataCadastro))
                .collect(Collectors.toList());
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
            clienteExistente.setDataCadastro(clienteAtualizado.getDataCadastro());

            return clienteRepository.save(clienteExistente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

}