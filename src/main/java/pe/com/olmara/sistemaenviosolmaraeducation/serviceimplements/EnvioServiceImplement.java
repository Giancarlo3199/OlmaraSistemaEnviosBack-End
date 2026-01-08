package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.AlertaEnvio;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Envio;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.TipoAlerta;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EstadoEnvio;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IAlertaEnvioRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IEnvioRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEnvioService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnvioServiceImplement implements IEnvioService {

    @Autowired
    private IEnvioRepository envioRepository;

    @Autowired
    private IAlertaEnvioRepository alertaEnvioRepository;


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

        // Traer el envío actual desde BD
        Envio envioDB = envioRepository.findById(e.getId())
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));

        // Guardar estado anterior
        EstadoEnvio estadoAnterior = envioDB.getEstado();


        // Actualizar campos (los que ya manejas)
        envioDB.setNumeroGuiaInterna(e.getNumeroGuiaInterna());
        envioDB.setNumeroFacturaInterna(e.getNumeroFacturaInterna());
        envioDB.setBoletaInterna(e.getBoletaInterna());
        envioDB.setNumeroGuiaExterna(e.getNumeroGuiaExterna());
        envioDB.setNumeroFacturaExterna(e.getNumeroFacturaExterna());
        envioDB.setNumeroTrackingExterno(e.getNumeroTrackingExterno());

        envioDB.setEmpresaTransporte(e.getEmpresaTransporte());
        envioDB.setTipoEnvio(e.getTipoEnvio());
        envioDB.setDireccionEnvio(e.getDireccionEnvio());

        envioDB.setCiudadPartida(e.getCiudadPartida());
        envioDB.setDestino(e.getDestino());
        /*  envioDB.setCiudadLlegada(e.getCiudadLlegada());*/

        envioDB.setCantidadCajas(e.getCantidadCajas());
        envioDB.setCantidadPaquetes(e.getCantidadPaquetes());
        envioDB.setCantidadSobres(e.getCantidadSobres());
        envioDB.setPesoTotal(e.getPesoTotal());

        envioDB.setFechaEnvio(e.getFechaEnvio());
        envioDB.setFechaEstimadaLlegada(e.getFechaEstimadaLlegada());
        envioDB.setFechaRecepcion(e.getFechaRecepcion());
        envioDB.setFechaTransito(e.getFechaTransito());

        envioDB.setMontoPagado(e.getMontoPagado());
        envioDB.setMoneda(e.getMoneda());

        envioDB.setOperador(e.getOperador());
        envioDB.setDestinatario(e.getDestinatario());
        envioDB.setComentarios(e.getComentarios());
        // Si ya está ENTREGADO, no permitir ningún cambio de estado
        if (estadoAnterior == EstadoEnvio.ENTREGADO) {
            envioDB.setEstado(EstadoEnvio.ENTREGADO);
        }
        // //LOGICA PARA PONER EN ESTADO ENTREGADO AUTOMATICAMENTE
        else if (envioDB.getFechaRecepcion() != null &&
                estadoAnterior != EstadoEnvio.ENTREGADO) {

            envioDB.setEstado(EstadoEnvio.ENTREGADO);

            // CREAR ALERTA AUTOMATICA CUANDO EL ENVIO SEA ENTREGADO
            AlertaEnvio alerta = new AlertaEnvio();
            alerta.setEnvio(envioDB);
            alerta.setEsLeida(false);
            alerta.setTipoAlerta(TipoAlerta.ENTREGADO);
            alerta.setMensaje(
                    "El envío con guía interna " +
                            envioDB.getNumeroGuiaInterna() +
                            " fue entregado correctamente."
            );
            alerta.setCreatedAt(LocalDateTime.now());

            alertaEnvioRepository.save(alerta);
        }
        //LOGICA PARA PONER EN ESTADO EN TRANSITO AUTOMATICAMENTE
        else if (envioDB.getFechaTransito() != null &&
                estadoAnterior != EstadoEnvio.EN_TRANSITO) {
            envioDB.setEstado(EstadoEnvio.EN_TRANSITO);
        }
        // Guardar envío
        envioRepository.save(envioDB);
    }

    @Override
    public void Eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}
