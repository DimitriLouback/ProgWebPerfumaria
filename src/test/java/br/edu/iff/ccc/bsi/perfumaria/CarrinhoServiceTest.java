package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Carrinho;
import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.CarrinhoRepository;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.CarrinhoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarrinhoServiceTest {

    @Mock
    private CarrinhoRepository carrinhoRepository;

    @Mock
    private PerfumeRepository perfumeRepository;

    @InjectMocks
    private CarrinhoService carrinhoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdicionarPerfume() {
        Carrinho carrinho = new Carrinho();
        Perfume perfume = new Perfume();
        perfume.setId(1L);

        when(carrinhoRepository.findById(1L)).thenReturn(Optional.of(carrinho));
        when(perfumeRepository.findById(1L)).thenReturn(Optional.of(perfume));
        when(carrinhoRepository.save(any(Carrinho.class))).thenReturn(carrinho);

        Carrinho result = carrinhoService.adicionarPerfume(1L, 1L);

        assertNotNull(result);
        assertTrue(result.getPerfumes().contains(perfume));
        verify(carrinhoRepository, times(1)).save(carrinho);
    }

    @Test
    void testRemoverPerfume() {
        Carrinho carrinho = new Carrinho();
        Perfume perfume = new Perfume();
        perfume.setId(1L);
        carrinho.getPerfumes().add(perfume);

        when(carrinhoRepository.findById(1L)).thenReturn(Optional.of(carrinho));
        when(perfumeRepository.findById(1L)).thenReturn(Optional.of(perfume));
        when(carrinhoRepository.save(any(Carrinho.class))).thenReturn(carrinho);

        Carrinho result = carrinhoService.removerPerfume(1L, 1L);

        assertNotNull(result);
        assertFalse(result.getPerfumes().contains(perfume));
        verify(carrinhoRepository, times(1)).save(carrinho);
    }

    @Test
    void testBuscarPorCliente() {
        Carrinho carrinho = new Carrinho();
        when(carrinhoRepository.findByClienteId(1L)).thenReturn(carrinho);

        Carrinho result = carrinhoService.buscarPorCliente(1L);

        assertNotNull(result);
        verify(carrinhoRepository, times(1)).findByClienteId(1L);
    }
}
