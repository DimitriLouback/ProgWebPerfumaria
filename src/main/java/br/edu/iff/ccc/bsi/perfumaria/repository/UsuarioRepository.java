package br.edu.iff.ccc.bsi.perfumaria.repository;

import br.edu.iff.ccc.bsi.perfumaria.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);


}
