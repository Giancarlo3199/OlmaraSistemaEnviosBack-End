package pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces;

import pe.com.olmara.sistemaenviosolmaraeducation.entities.AlertaEnvio;

import java.util.List;

public interface IAlertaEnvioService {
    List<AlertaEnvio> listar();
    void Registrar(AlertaEnvio a);
    AlertaEnvio listarporid(Long id);
    void Modificar(AlertaEnvio a);
    void Eliminar(Long id);

    //PARA LAS ALERTAS SI SON LEIDAS O NO
    List<AlertaEnvio> listarNoLeidas();
    void marcarComoLeida(Long id);
    long contarNoLeidas();
}