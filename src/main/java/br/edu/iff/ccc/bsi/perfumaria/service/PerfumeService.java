package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;


    public Perfume inserirPerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public Perfume buscarPorId(Long id) {
        return perfumeRepository.findById(id).orElse(null);
    }

    public List<Perfume> listarPerfumes() {
        return perfumeRepository.findAll();
    }

    public void removerPerfumePorId(Long id) {
        perfumeRepository.deleteById(id);
    }
}