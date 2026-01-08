package pe.com.olmara.sistemaenviosolmaraeducation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.AlertaEnvio;

import java.util.List;

@Repository
public interface IAlertaEnvioRepository extends JpaRepository<AlertaEnvio, Long> {

        List<AlertaEnvio> findByEsLeidaFalseOrderByCreatedAtDesc();
        long countByEsLeidaFalse();

}