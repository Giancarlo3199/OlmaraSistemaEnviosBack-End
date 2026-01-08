package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.AlertaEnvioDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.AlertaEnvio;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IAlertaEnvioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alerta-envio")
public class AlertaEnvioController {

    @Autowired
    private IAlertaEnvioService aS;

    @GetMapping
    public List<AlertaEnvioDTO> Listar() {
        return aS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlertaEnvioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody AlertaEnvioDTO dto) {
        ModelMapper m = new ModelMapper();
        AlertaEnvio a = m.map(dto, AlertaEnvio.class);
        aS.Registrar(a);
    }

    @GetMapping("/{id}")
    public AlertaEnvioDTO Listarporid(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        AlertaEnvioDTO dto = m.map(aS.listarporid(id), AlertaEnvioDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody AlertaEnvioDTO dto) {
        ModelMapper m = new ModelMapper();
        AlertaEnvio a = m.map(dto, AlertaEnvio.class);
        aS.Modificar(a);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Long id) {
        aS.Eliminar(id);
    }

    @GetMapping("/no-leidas")
    public List<AlertaEnvio> listarNoLeidas() {
        return aS.listarNoLeidas();
    }

    @GetMapping("/count")
    public long contarNoLeidas() {
        return aS.contarNoLeidas();
    }

    @PutMapping("/leer/{id}")
    public void marcarComoLeida(@PathVariable Long id) {
        aS.marcarComoLeida(id);
    }
}
