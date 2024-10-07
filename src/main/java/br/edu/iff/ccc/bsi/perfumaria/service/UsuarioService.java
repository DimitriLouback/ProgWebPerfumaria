package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Endereco;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void removerUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }


    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            usuario.setUsername(usuarioAtualizado.getUsername());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setCPF(usuarioAtualizado.getCPF());
            usuario.setCelular(usuarioAtualizado.getCelular());


            if (usuarioAtualizado.getEndereco() != null) {
                Endereco enderecoAtualizado = usuarioAtualizado.getEndereco();
                usuario.getEndereco().setRua(enderecoAtualizado.getRua());
                usuario.getEndereco().setNumero(enderecoAtualizado.getNumero());
                usuario.getEndereco().setCidade(enderecoAtualizado.getCidade());
                usuario.getEndereco().setBairro(enderecoAtualizado.getBairro());
                usuario.getEndereco().setCEP(enderecoAtualizado.getCEP());
                usuario.getEndereco().setUF(enderecoAtualizado.getUF());
            }

            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado");
        }
    }
}