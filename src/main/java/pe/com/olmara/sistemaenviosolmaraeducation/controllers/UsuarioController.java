package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.UsuarioConPasswordDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.UsuarioDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.listar().stream().map( x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioConPasswordDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.Registrar(u);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarporid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarporid(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioConPasswordDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.Modificar(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.Eliminar(id);
    }
}

