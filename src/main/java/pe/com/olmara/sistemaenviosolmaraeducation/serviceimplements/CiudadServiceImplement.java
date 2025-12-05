package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Ciudad;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.ICiudadRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.ICiudadService;

import java.util.List;

@Service
public class CiudadServiceImplement implements ICiudadService {

    @Autowired
    private ICiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> listar() {
        return ciudadRepository.findAll();
    }

    @Override
    public void Registrar(Ciudad c) {
        ciudadRepository.save(c);
    }

    @Override
    public Ciudad listarporid(Integer id) {
        return ciudadRepository.findById(id).orElse(new Ciudad());
    }

    @Override
    public void Modificar(Ciudad c) {
        ciudadRepository.save(c);
    }

    @Override
    public void Eliminar(Integer id) {
        ciudadRepository.deleteById(id);
    }
}
