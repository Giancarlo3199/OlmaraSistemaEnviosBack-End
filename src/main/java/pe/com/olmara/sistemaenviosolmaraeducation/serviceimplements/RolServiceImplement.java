package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Rol;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IRolRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void Registrar(Rol r) {
        rolRepository.save(r);
    }

    @Override
    public Rol listarporid(Integer id) {
        return rolRepository.findById(id).orElse(new Rol());
    }

    @Override
    public void Modificar(Rol r) {
        rolRepository.save(r);
    }

    @Override
    public void Eliminar(Integer id) {
        rolRepository.deleteById(id);
    }
}
