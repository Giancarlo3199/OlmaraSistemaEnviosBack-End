package pe.com.olmara.sistemaenviosolmaraeducation.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnvioDTO {

    private Long id;

    private String numeroGuiaInterna;
    private String numeroFacturaInterna;
    private String numeroGuiaExterna;
    private String numeroFacturaExterna;
    private String numeroTrackingExterno;
    private String boletaInterna;


    private EmpresaTransporteDTO empresaTransporte;

    private String tipoEnvio;
    private String direccionEnvio;

    private CiudadDTO ciudadPartida;
    private String destino;
    /*
    private CiudadDTO ciudadLlegada; */

    private Integer cantidadCajas;
    private Integer cantidadPaquetes;
    private Integer cantidadSobres;

    private BigDecimal pesoTotal;

    private LocalDate fechaEnvio;
    private LocalDate fechaEstimadaLlegada;
    private LocalDate fechaRecepcion;
    private LocalDate fechaTransito;

    private BigDecimal montoPagado;
    private String moneda;

    private String estado;
    private String comentarios;

    private UsuarioDTO operador;
    private UsuarioDTO destinatario;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaTransito() {
        return fechaTransito;
    }

    public void setFechaTransito(LocalDate fechaTransito) {
        this.fechaTransito = fechaTransito;
    }

    public String getBoletaInterna() {
        return boletaInterna;
    }

    public void setBoletaInterna(String boletaInterna) {
        this.boletaInterna = boletaInterna;
    }

    public String getNumeroGuiaInterna() {
        return numeroGuiaInterna;
    }

    public void setNumeroGuiaInterna(String numeroGuiaInterna) {
        this.numeroGuiaInterna = numeroGuiaInterna;
    }

    public String getNumeroFacturaInterna() {
        return numeroFacturaInterna;
    }

    public void setNumeroFacturaInterna(String numeroFacturaInterna) {
        this.numeroFacturaInterna = numeroFacturaInterna;
    }

    public String getNumeroGuiaExterna() {
        return numeroGuiaExterna;
    }

    public void setNumeroGuiaExterna(String numeroGuiaExterna) {
        this.numeroGuiaExterna = numeroGuiaExterna;
    }

    public String getNumeroFacturaExterna() {
        return numeroFacturaExterna;
    }

    public void setNumeroFacturaExterna(String numeroFacturaExterna) {
        this.numeroFacturaExterna = numeroFacturaExterna;
    }

    public String getNumeroTrackingExterno() {
        return numeroTrackingExterno;
    }

    public void setNumeroTrackingExterno(String numeroTrackingExterno) {
        this.numeroTrackingExterno = numeroTrackingExterno;
    }

    public EmpresaTransporteDTO getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(EmpresaTransporteDTO empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public CiudadDTO getCiudadPartida() {
        return ciudadPartida;
    }

    public void setCiudadPartida(CiudadDTO ciudadPartida) {
        this.ciudadPartida = ciudadPartida;
    }

    public Integer getCantidadPaquetes() {
        return cantidadPaquetes;
    }

    public void setCantidadPaquetes(Integer cantidadPaquetes) {
        this.cantidadPaquetes = cantidadPaquetes;
    }
 /*
    public CiudadDTO getCiudadLlegada() {
        return ciudadLlegada;
    }

    public void setCiudadLlegada(CiudadDTO ciudadLlegada) {
        this.ciudadLlegada = ciudadLlegada;
    }
*/
    public Integer getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(Integer cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public Integer getCantidadSobres() {
        return cantidadSobres;
    }

    public void setCantidadSobres(Integer cantidadSobres) {
        this.cantidadSobres = cantidadSobres;
    }

    public BigDecimal getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(BigDecimal pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalDate getFechaEstimadaLlegada() {
        return fechaEstimadaLlegada;
    }

    public void setFechaEstimadaLlegada(LocalDate fechaEstimadaLlegada) {
        this.fechaEstimadaLlegada = fechaEstimadaLlegada;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public UsuarioDTO getOperador() {
        return operador;
    }

    public void setOperador(UsuarioDTO operador) {
        this.operador = operador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UsuarioDTO getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(UsuarioDTO destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
