package pe.com.olmara.sistemaenviosolmaraeducation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EventoSeguimiento;

@Repository
public interface IEventoSeguimientoRepository extends JpaRepository<EventoSeguimiento, Long> {

}
