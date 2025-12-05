package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.Envio;

import java.util.List;

// IEnvioService.java
public interface IEnvioService {
    List<Envio> listar();
    void Registrar(Envio e);
    Envio listarporid(Long id);
    void Modificar(Envio e);
    void Eliminar(Long id);
}
