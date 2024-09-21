package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService extends UsuarioService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    // Métodos específicos para gerenciamento de perfumes

    public Perfume adicionarPerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public Perfume buscarPerfumePorId(Long id) {
        return perfumeRepository.findById(id).orElse(null);
    }

    public List<Perfume> listarPerfumes() {
        return perfumeRepository.findAll();
    }

    public void removerPerfumePorId(Long id) {
        perfumeRepository.deleteById(id);
    }
}