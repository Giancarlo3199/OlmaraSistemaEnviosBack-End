package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Envio;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IEnvioRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEnvioService;

import java.util.List;

@Service
public class EnvioServiceImplement implements IEnvioService {

    @Autowired
    private IEnvioRepository envioRepository;

    @Override
    public List<Envio> listar() {
        return envioRepository.findAll();
    }

    @Override
    public void Registrar(Envio e) {
        envioRepository.save(e);
    }

    @Override
    public Envio listarporid(Long id) {
        return envioRepository.findById(id).orElse(new Envio());
    }

    @Override
    public void Modificar(Envio e) {
        envioRepository.save(e);
    }

    @Override
    public void Eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}
