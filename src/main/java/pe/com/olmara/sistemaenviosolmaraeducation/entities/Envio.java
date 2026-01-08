package pe.com.olmara.sistemaenviosolmaraeducation.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Documentos internos y externos
    @Column(name = "numero_guia_interna", length = 50)
    private String numeroGuiaInterna;

    @Column(name = "numero_factura_interna", length = 50)
    private String numeroFacturaInterna;

    @Column(name = "boleta_interna", length = 50)
    private String boletaInterna;

    @Column(name = "numero_guia_externa", length = 50)
    private String numeroGuiaExterna;

    @Column(name = "numero_factura_externa", length = 50)
    private String numeroFacturaExterna;

    @Column(name = "numero_tracking_externo", length = 50)
    private String numeroTrackingExterno;

    // Empresa de transporte (FK empresas_transporte.id)
    @ManyToOne
    @JoinColumn(name = "empresa_transporte_id", nullable = false)
    private EmpresaTransporte empresaTransporte;

    // Tipo de envío: DOMICILIO / AGENCIA
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_envio", length = 20)
    private TipoEnvio tipoEnvio;

    @Column(name = "direccion_envio", columnDefinition = "text")
    private String direccionEnvio;

    // Ciudades (FK ciudades.idCiudad)
    @ManyToOne
    @JoinColumn(name = "ciudad_partida_id", nullable = false)
    private Ciudad ciudadPartida;

    @Column(name = "destino", length = 150)
    private String destino;
    /*
    @ManyToOne
    @JoinColumn(name = "ciudad_llegada_id")
    private Ciudad ciudadLlegada;*/

    // Cantidades
    @Column(name = "cantidad_cajas")
    private Integer cantidadCajas;

    @Column(name = "cantidad_paquetes")
    private Integer cantidadPaquetes;

    @Column(name = "cantidad_sobres")
    private Integer cantidadSobres;

    // Peso total en KG
    @Column(name = "peso_total_kg", precision = 10, scale = 2)
    private BigDecimal pesoTotal;

    // Fechas
    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @Column(name = "fecha_estimada_llegada")
    private LocalDate fechaEstimadaLlegada;

    @Column(name = "fecha_recepcion")
    private LocalDate fechaRecepcion;

    @Column(name = "fecha_transito")
    private LocalDate fechaTransito;


    // Pago
    @Column(name = "monto_pagado", precision = 10, scale = 2)
    private BigDecimal montoPagado;

    @Column(name = "moneda", length = 10)
    private String moneda;

    // Estado del envío
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20)
    private EstadoEnvio estado;

    @Column(name = "comentarios", columnDefinition = "text")
    private String comentarios;

    // Operador (empleado que registra el envío)
    @ManyToOne
    @JoinColumn(name = "operador_id", nullable = false)
    private Usuario operador;

    // Destinatario (cliente)
    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private Usuario destinatario;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;




    public Envio() {
    }

    public Envio(String destino, String numeroTrackingExterno, String numeroFacturaExterna, String numeroGuiaExterna, String numeroFacturaInterna,String boletaInterna, String numeroGuiaInterna, Long id, EmpresaTransporte empresaTransporte, TipoEnvio tipoEnvio, String direccionEnvio, Ciudad ciudadPartida, Integer cantidadCajas, Integer cantidadPaquetes, Integer cantidadSobres, BigDecimal pesoTotal, LocalDate fechaEnvio, LocalDate fechaEstimadaLlegada, LocalDate fechaRecepcion, BigDecimal montoPagado, String moneda, String comentarios, EstadoEnvio estado, Usuario operador, Usuario destinatario, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDate fechaTransito) {

        this.boletaInterna = boletaInterna;
        this.numeroTrackingExterno = numeroTrackingExterno;
        this.numeroFacturaExterna = numeroFacturaExterna;
        this.numeroGuiaExterna = numeroGuiaExterna;
        this.numeroFacturaInterna = numeroFacturaInterna;
        this.numeroGuiaInterna = numeroGuiaInterna;
        this.id = id;
        this.empresaTransporte = empresaTransporte;
        this.tipoEnvio = tipoEnvio;
        this.direccionEnvio = direccionEnvio;
        this.ciudadPartida = ciudadPartida;
        this.destino= destino;
        /*this.ciudadLlegada = ciudadLlegada;*/
        this.cantidadCajas = cantidadCajas;
        this.cantidadPaquetes = cantidadPaquetes;
        this.cantidadSobres = cantidadSobres;
        this.pesoTotal = pesoTotal;
        this.fechaEnvio = fechaEnvio;
        this.fechaEstimadaLlegada = fechaEstimadaLlegada;
        this.fechaRecepcion = fechaRecepcion;
        this.montoPagado = montoPagado;
        this.moneda = moneda;
        this.comentarios = comentarios;
        this.estado = estado;
        this.operador = operador;
        this.destinatario = destinatario;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fechaTransito = fechaTransito;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(EmpresaTransporte empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Ciudad getCiudadPartida() {
        return ciudadPartida;
    }

    public void setCiudadPartida(Ciudad ciudadPartida) {
        this.ciudadPartida = ciudadPartida;
    }
/*
    public Ciudad getCiudadLlegada() {
        return ciudadLlegada;
    }

    public void setCiudadLlegada(Ciudad ciudadLlegada) {
        this.ciudadLlegada = ciudadLlegada;
    }
*/
    public Integer getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(Integer cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    public Integer getCantidadPaquetes() {
        return cantidadPaquetes;
    }

    public void setCantidadPaquetes(Integer cantidadPaquetes) {
        this.cantidadPaquetes = cantidadPaquetes;
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

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
