package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listar();
    void Registrar(Usuario u);
    Usuario listarporid(Integer id);
    void Modificar(Usuario u);
    void Eliminar(Integer id);
}