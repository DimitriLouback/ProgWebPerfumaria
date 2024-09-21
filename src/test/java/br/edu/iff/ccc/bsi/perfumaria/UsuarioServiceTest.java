package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setUsername("João");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.inserirUsuario(usuario);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("João", result.getUsername());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testBuscarPorId() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testListarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.listarUsuarios();

        assertEquals(2, result.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testRemoverUsuarioPorId() {
        doNothing().when(usuarioRepository).deleteById(1L);

        usuarioService.removerUsuarioPorId(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}
