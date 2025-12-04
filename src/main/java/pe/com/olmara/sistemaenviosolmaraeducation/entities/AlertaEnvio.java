package pe.com.olmara.sistemaenviosolmaraeducation.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alertas_envio")
public class AlertaEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con Envio (FK envio_id)
    @ManyToOne
    @JoinColumn(name = "envio_id", nullable = false)
    private Envio envio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_alerta", length = 30)
    private TipoAlerta tipoAlerta;

    @Column(name = "mensaje", columnDefinition = "text")
    private String mensaje;

    @Column(name = "es_leida")
    private Boolean esLeida;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public AlertaEnvio() {
    }

    public AlertaEnvio(Long id, Envio envio, TipoAlerta tipoAlerta, String mensaje, Boolean esLeida, LocalDateTime createdAt) {
        this.id = id;
        this.envio = envio;
        this.tipoAlerta = tipoAlerta;
        this.mensaje = mensaje;
        this.esLeida = esLeida;
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

    public TipoAlerta getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getEsLeida() {
        return esLeida;
    }

    public void setEsLeida(Boolean esLeida) {
        this.esLeida = esLeida;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
