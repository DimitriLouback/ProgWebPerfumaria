package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.PerfumeService;
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

class PerfumeServiceTest {

    @Mock
    private PerfumeRepository perfumeRepository;

    @InjectMocks
    private PerfumeService perfumeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirPerfume() {
        Perfume perfume = new Perfume();
        perfume.setId(1L);
        perfume.setNome("Perfume X");

        when(perfumeRepository.save(any(Perfume.class))).thenReturn(perfume);

        Perfume result = perfumeService.inserirPerfume(perfume);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Perfume X", result.getNome());
        verify(perfumeRepository, times(1)).save(perfume);
    }

    @Test
    void testBuscarPorId() {
        Perfume perfume = new Perfume();
        perfume.setId(1L);

        when(perfumeRepository.findById(1L)).thenReturn(Optional.of(perfume));

        Perfume result = perfumeService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(perfumeRepository, times(1)).findById(1L);
    }

    @Test
    void testListarPerfumes() {
        List<Perfume> perfumes = new ArrayList<>();
        Perfume perfume1 = new Perfume();
        perfume1.setId(1L);
        Perfume perfume2 = new Perfume();
        perfume2.setId(2L);
        perfumes.add(perfume1);
        perfumes.add(perfume2);

        when(perfumeRepository.findAll()).thenReturn(perfumes);

        List<Perfume> result = perfumeService.listarPerfumes();

        assertEquals(2, result.size());
        verify(perfumeRepository, times(1)).findAll();
    }

    @Test
    void testRemoverPerfumePorId() {
        doNothing().when(perfumeRepository).deleteById(1L);

        perfumeService.removerPerfumePorId(1L);

        verify(perfumeRepository, times(1)).deleteById(1L);
    }
}
