package pe.com.olmara.sistemaenviosolmaraeducation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Envio;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnvioRepository extends JpaRepository<Envio, Long> {

}