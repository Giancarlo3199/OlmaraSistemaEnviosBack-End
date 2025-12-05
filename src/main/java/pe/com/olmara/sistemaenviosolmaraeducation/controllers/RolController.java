package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.RolDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Rol;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> Listar() {
        return rS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.Registrar(r);
    }

    @GetMapping("/{id}")
    public RolDTO Listarporid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.listarporid(id), RolDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.Modificar(r);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Integer id) {
        rS.Eliminar(id);
    }
}

