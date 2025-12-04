package pe.com.olmara.sistemaenviosolmaraeducation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

}