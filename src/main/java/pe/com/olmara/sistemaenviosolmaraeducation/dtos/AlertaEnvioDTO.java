package pe.com.olmara.sistemaenviosolmaraeducation.dtos;

import java.time.LocalDateTime;

public class AlertaEnvioDTO {

    private Long id;
    private EnvioDTO envio;
    private String tipoAlerta;
    private String mensaje;
    private Boolean esLeida;
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

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
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
