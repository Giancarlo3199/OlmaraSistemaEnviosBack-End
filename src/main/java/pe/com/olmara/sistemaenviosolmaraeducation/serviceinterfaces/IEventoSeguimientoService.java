package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.EventoSeguimiento;

import java.util.List;

public interface IEventoSeguimientoService {
    List<EventoSeguimiento> listar();
    void Registrar(EventoSeguimiento e);
    EventoSeguimiento listarporid(Long id);
    void Modificar(EventoSeguimiento e);
    void Eliminar(Long id);
}
