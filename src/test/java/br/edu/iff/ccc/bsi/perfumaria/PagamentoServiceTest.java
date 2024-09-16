package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Pagamento;
import br.edu.iff.ccc.bsi.perfumaria.repository.PagamentoRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.PagamentoService;
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

class PagamentoServiceTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoService pagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1L);

        when(pagamentoRepository.save(any(Pagamento.class))).thenReturn(pagamento);

        Pagamento result = pagamentoService.inserirPagamento(pagamento);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pagamentoRepository, times(1)).save(pagamento);
    }

    @Test
    void testBuscarPorId() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1L);

        when(pagamentoRepository.findById(1L)).thenReturn(Optional.of(pagamento));

        Pagamento result = pagamentoService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pagamentoRepository, times(1)).findById(1L);
    }

    @Test
    void testListarPagamentos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        Pagamento pagamento1 = new Pagamento();
        pagamento1.setId(1L);
        Pagamento pagamento2 = new Pagamento();
        pagamento2.setId(2L);
        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);

        when(pagamentoRepository.findAll()).thenReturn(pagamentos);

        List<Pagamento> result = pagamentoService.listarPagamentos();

        assertEquals(2, result.size());
        verify(pagamentoRepository, times(1)).findAll();
    }

    @Test
    void testRemoverPagamentoPorId() {
        doNothing().when(pagamentoRepository).deleteById(1L);

        pagamentoService.removerPagamentoPorId(1L);

        verify(pagamentoRepository, times(1)).deleteById(1L);
    }
}
