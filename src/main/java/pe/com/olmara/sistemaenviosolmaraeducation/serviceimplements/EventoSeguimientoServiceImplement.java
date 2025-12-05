package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EventoSeguimiento;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IEventoSeguimientoRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEventoSeguimientoService;

import java.util.List;

@Service
public class EventoSeguimientoServiceImplement implements IEventoSeguimientoService {

    @Autowired
    private IEventoSeguimientoRepository eventoSeguimientoRepository;

    @Override
    public List<EventoSeguimiento> listar() {
        return eventoSeguimientoRepository.findAll();
    }

    @Override
    public void Registrar(EventoSeguimiento e) {
        eventoSeguimientoRepository.save(e);
    }

    @Override
    public EventoSeguimiento listarporid(Long id) {
        return eventoSeguimientoRepository.findById(id).orElse(new EventoSeguimiento());
    }

    @Override
    public void Modificar(EventoSeguimiento e) {
        eventoSeguimientoRepository.save(e);
    }

    @Override
    public void Eliminar(Long id) {
        eventoSeguimientoRepository.deleteById(id);
    }
}