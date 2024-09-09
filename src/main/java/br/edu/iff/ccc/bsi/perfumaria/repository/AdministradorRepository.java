package br.edu.iff.ccc.bsi.perfumaria.repository;

import br.edu.iff.ccc.bsi.perfumaria.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {


}
