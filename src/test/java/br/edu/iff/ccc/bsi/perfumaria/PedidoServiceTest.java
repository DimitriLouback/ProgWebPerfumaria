package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pedido;
import br.edu.iff.ccc.bsi.perfumaria.repository.PedidoRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.PedidoService;
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

class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirPedido() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);

        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        Pedido result = pedidoService.inserirPedido(pedido);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    void testBuscarPorId() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        Pedido result = pedidoService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pedidoRepository, times(1)).findById(1L);
    }

    @Test
    void testListarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido1 = new Pedido();
        pedido1.setId(1L);
        Pedido pedido2 = new Pedido();
        pedido2.setId(2L);
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        when(pedidoRepository.findAll()).thenReturn(pedidos);

        List<Pedido> result = pedidoService.listarPedidos();

        assertEquals(2, result.size());
        verify(pedidoRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarPedido() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);

        when(pedidoRepository.existsById(1L)).thenReturn(true);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.atualizarPedido(1L, pedido);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    void testRemoverPedidoPorId() {
        doNothing().when(pedidoRepository).deleteById(1L);

        pedidoService.removerPedidoPorId(1L);

        verify(pedidoRepository, times(1)).deleteById(1L);
    }
}
