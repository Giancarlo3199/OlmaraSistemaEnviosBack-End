package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> listar();
    void Registrar(Rol r);
    Rol listarporid(Integer id);
    void Modificar(Rol r);
    void Eliminar(Integer id);
}