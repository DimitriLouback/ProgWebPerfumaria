package br.edu.iff.ccc.bsi.perfumaria.service;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import br.edu.iff.ccc.bsi.perfumaria.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Perfume atualizarPerfume(Long id, Perfume perfumeAtualizado) {
        Optional<Perfume> perfumeExistente = perfumeRepository.findById(id);

        if (perfumeExistente.isPresent()) {
            Perfume perfume = perfumeExistente.get();


            perfume.setNome(perfumeAtualizado.getNome());
            perfume.setPreco(perfumeAtualizado.getPreco());
            perfume.setQuantidadeEmEstoque(perfumeAtualizado.getQuantidadeEmEstoque());
            perfume.setFragrancia(perfumeAtualizado.getFragrancia());
            perfume.setMarca(perfumeAtualizado.getMarca());
            perfume.setVolume(perfumeAtualizado.getVolume());


            return perfumeRepository.save(perfume);
        } else {
            throw new RuntimeException("Perfume com ID " + id + " não encontrado");
        }
    }
}