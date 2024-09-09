package br.edu.iff.ccc.bsi.perfumaria.repository;

import br.edu.iff.ccc.bsi.perfumaria.entities.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

    List<Perfume> findByMarca(String marca);


}
