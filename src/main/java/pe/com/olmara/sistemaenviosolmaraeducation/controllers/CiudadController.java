package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.CiudadDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Ciudad;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.ICiudadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private ICiudadService cS;

    @GetMapping
    public List<CiudadDTO> Listar() {
        return cS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CiudadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody CiudadDTO dto) {
        ModelMapper m = new ModelMapper();
        Ciudad c = m.map(dto, Ciudad.class);
        cS.Registrar(c);
    }

    @GetMapping("/{id}")
    public CiudadDTO Listarporid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CiudadDTO dto = m.map(cS.listarporid(id), CiudadDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody CiudadDTO dto) {
        ModelMapper m = new ModelMapper();
        Ciudad c = m.map(dto, Ciudad.class);
        cS.Modificar(c);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Integer id) {
        cS.Eliminar(id);
    }
}
