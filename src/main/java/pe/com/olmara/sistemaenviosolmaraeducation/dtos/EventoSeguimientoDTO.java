package pe.com.olmara.sistemaenviosolmaraeducation.dtos;

import java.time.LocalDateTime;

public class EventoSeguimientoDTO {

    private Long id;
    private EnvioDTO envio;
    private String origenEvento;
    private String estado;
    private String descripcion;
    private LocalDateTime fechaEvento;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnvioDTO getEnvio() {
        return envio;
    }

    public void setEnvio(EnvioDTO envio) {
        this.envio = envio;
    }

    public String getOrigenEvento() {
        return origenEvento;
    }

    public void setOrigenEvento(String origenEvento) {
        this.origenEvento = origenEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDateTime fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}