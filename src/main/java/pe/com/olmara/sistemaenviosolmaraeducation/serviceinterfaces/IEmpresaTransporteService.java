package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.EmpresaTransporte;

import java.util.List;

// IEmpresaTransporteService.java
public interface IEmpresaTransporteService {
    List<EmpresaTransporte> listar();
    void Registrar(EmpresaTransporte e);
    EmpresaTransporte listarporid(Integer id);
    void Modificar(EmpresaTransporte e);
    void Eliminar(Integer id);
}

