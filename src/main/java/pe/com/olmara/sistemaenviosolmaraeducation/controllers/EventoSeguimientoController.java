package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.EventoSeguimientoDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EventoSeguimiento;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEventoSeguimientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento-seguimiento")
public class EventoSeguimientoController {

    @Autowired
    private IEventoSeguimientoService eS;

    @GetMapping
    public List<EventoSeguimientoDTO> Listar() {
        return eS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventoSeguimientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody EventoSeguimientoDTO dto) {
        ModelMapper m = new ModelMapper();
        EventoSeguimiento e = m.map(dto, EventoSeguimiento.class);
        eS.Registrar(e);
    }

    @GetMapping("/{id}")
    public EventoSeguimientoDTO Listarporid(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        EventoSeguimientoDTO dto = m.map(eS.listarporid(id), EventoSeguimientoDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody EventoSeguimientoDTO dto) {
        ModelMapper m = new ModelMapper();
        EventoSeguimiento e = m.map(dto, EventoSeguimiento.class);
        eS.Modificar(e);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Long id) {
        eS.Eliminar(id);
    }
}
