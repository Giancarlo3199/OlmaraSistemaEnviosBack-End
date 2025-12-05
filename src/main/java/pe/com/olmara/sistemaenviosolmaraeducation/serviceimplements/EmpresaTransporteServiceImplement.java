package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EmpresaTransporte;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IEmpresaTransporteRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEmpresaTransporteService;

import java.util.List;

@Service
public class EmpresaTransporteServiceImplement implements IEmpresaTransporteService {

    @Autowired
    private IEmpresaTransporteRepository empresaTransporteRepository;

    @Override
    public List<EmpresaTransporte> listar() {
        return empresaTransporteRepository.findAll();
    }

    @Override
    public void Registrar(EmpresaTransporte e) {
        empresaTransporteRepository.save(e);
    }

    @Override
    public EmpresaTransporte listarporid(Integer id) {
        return empresaTransporteRepository.findById(id).orElse(new EmpresaTransporte());
    }

    @Override
    public void Modificar(EmpresaTransporte e) {
        empresaTransporteRepository.save(e);
    }

    @Override
    public void Eliminar(Integer id) {
        empresaTransporteRepository.deleteById(id);
    }
}
