package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Cliente;
import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import br.edu.iff.ccc.bsi.perfumaria.repository.UsuarioRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirCliente() {
        Cliente cliente = new Cliente();
        cliente.setUsername("Cliente Teste");

        when(usuarioRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.inserirCliente(cliente);

        assertNotNull(result);
        assertEquals("Cliente Teste", result.getUsername());
        verify(usuarioRepository, times(1)).save(cliente);
    }

    @Test
    void testBuscarPorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarPorNome() {
        Cliente cliente = new Cliente();
        cliente.setUsername("Cliente Teste");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(cliente);

        when(usuarioRepository.findByUsername("Cliente Teste")).thenReturn(usuarios);

        Cliente result = clienteService.buscarPorNome("Cliente Teste");

        assertNotNull(result);
        assertEquals("Cliente Teste", result.getUsername());
        verify(usuarioRepository, times(1)).findByUsername("Cliente Teste");
    }

    @Test
    void testListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setUsername("Cliente 1");
        Cliente cliente2 = new Cliente();
        cliente2.setUsername("Cliente 2");
        clientes.add(cliente1);
        clientes.add(cliente2);

        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>(clientes));

        List<Cliente> result = clienteService.listarClientes();

        assertEquals(2, result.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testRemoverClientePorId() {
        doNothing().when(usuarioRepository).deleteById(1L);

        clienteService.removerClientePorId(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }

    @Test
    void testBuscarPorDataNascimento() {
        Date dataNascimento = new Date();
        Cliente cliente = new Cliente();
        cliente.setDataNascimento(dataNascimento);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);

        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>(clientes));

        List<Cliente> result = clienteService.buscarPorDataNascimento(dataNascimento);

        assertEquals(1, result.size());
        assertEquals(dataNascimento, result.get(0).getDataNascimento());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorDataCadastro() {
        Date dataCadastro = new Date();
        Cliente cliente = new Cliente();
        cliente.setDataCadastro(dataCadastro);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);

        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>(clientes));

        List<Cliente> result = clienteService.buscarPorDataCadastro(dataCadastro);

        assertEquals(1, result.size());
        assertEquals(dataCadastro, result.get(0).getDataCadastro());
        verify(usuarioRepository, times(1)).findAll();
    }
}
