package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.Ciudad;

import java.util.List;

public interface ICiudadService {
    List<Ciudad> listar();
    void Registrar(Ciudad c);
    Ciudad listarporid(Integer id);
    void Modificar(Ciudad c);
    void Eliminar(Integer id);
}
