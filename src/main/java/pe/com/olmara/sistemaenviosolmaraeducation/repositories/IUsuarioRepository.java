package pe.com.olmara.sistemaenviosolmaraeducation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findOneByUsername(String username);
}
