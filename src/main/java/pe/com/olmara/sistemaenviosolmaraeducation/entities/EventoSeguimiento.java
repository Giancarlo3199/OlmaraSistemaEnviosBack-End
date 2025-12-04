package pe.com.olmara.sistemaenviosolmaraeducation.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos_seguimiento")
public class EventoSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con Envio (FK envio_id)
    @ManyToOne
    @JoinColumn(name = "envio_id", nullable = false)
    private Envio envio;

    @Enumerated(EnumType.STRING)
    @Column(name = "origen_evento", length = 20)
    private OrigenEvento origenEvento;

    // Aquí reutilizamos el mismo enum de estado del envío
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30)
    private EstadoEnvio estado;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public EventoSeguimiento() {
    }

    public EventoSeguimiento(Long id, Envio envio, OrigenEvento origenEvento, EstadoEnvio estado, String descripcion, LocalDateTime fechaEvento, LocalDateTime createdAt) {
        this.id = id;
        this.envio = envio;
        this.origenEvento = origenEvento;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public OrigenEvento getOrigenEvento() {
        return origenEvento;
    }

    public void setOrigenEvento(OrigenEvento origenEvento) {
        this.origenEvento = origenEvento;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
