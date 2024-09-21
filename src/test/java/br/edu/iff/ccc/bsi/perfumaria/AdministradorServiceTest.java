package br.edu.iff.ccc.bsi.perfumaria;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import br.edu.iff.ccc.bsi.perfumaria.service.AdministradorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministradorServiceTest {

    @Mock
    private PerfumeRepository perfumeRepository;

    @InjectMocks
    private AdministradorService administradorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdicionarPerfume() {
        //Cenário
        Perfume perfume = new Perfume();
        perfume.setNome("Perfume Teste");

        when(perfumeRepository.save(any(Perfume.class))).thenReturn(perfume);

        //Ação
        Perfume result = administradorService.adicionarPerfume(perfume);

        //Verificação
        assertNotNull(result);
        assertEquals("Perfume Teste", result.getNome());
        verify(perfumeRepository, times(1)).save(perfume);
    }

    @Test
    void testBuscarPerfumePorId() {
        Perfume perfume = new Perfume();
        perfume.setId(1L);

        when(perfumeRepository.findById(1L)).thenReturn(Optional.of(perfume));

        Perfume result = administradorService.buscarPerfumePorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(perfumeRepository, times(1)).findById(1L);
    }

    @Test
    void testListarPerfumes() {
        List<Perfume> perfumes = new ArrayList<>();
        perfumes.add(new Perfume());

        when(perfumeRepository.findAll()).thenReturn(perfumes);

        List<Perfume> result = administradorService.listarPerfumes();

        assertEquals(1, result.size());
        verify(perfumeRepository, times(1)).findAll();
    }

    @Test
    void testRemoverPerfumePorId() {
        doNothing().when(perfumeRepository).deleteById(1L);

        administradorService.removerPerfumePorId(1L);

        verify(perfumeRepository, times(1)).deleteById(1L);
    }
}
