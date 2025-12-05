package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.AlertaEnvio;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IAlertaEnvioRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IAlertaEnvioService;

import java.util.List;

@Service
public class AlertaEnvioServiceImplement implements IAlertaEnvioService {

    @Autowired
    private IAlertaEnvioRepository alertaEnvioRepository;

    @Override
    public List<AlertaEnvio> listar() {
        return alertaEnvioRepository.findAll();
    }

    @Override
    public void Registrar(AlertaEnvio a) {
        alertaEnvioRepository.save(a);
    }

    @Override
    public AlertaEnvio listarporid(Long id) {
        return alertaEnvioRepository.findById(id).orElse(new AlertaEnvio());
    }

    @Override
    public void Modificar(AlertaEnvio a) {
        alertaEnvioRepository.save(a);
    }

    @Override
    public void Eliminar(Long id) {
        alertaEnvioRepository.deleteById(id);
    }
}
