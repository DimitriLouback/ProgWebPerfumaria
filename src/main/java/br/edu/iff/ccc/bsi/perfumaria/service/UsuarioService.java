package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}