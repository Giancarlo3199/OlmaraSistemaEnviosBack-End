package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.EnvioDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Envio;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEnvioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    @Autowired
    private IEnvioService eS;

    @GetMapping
    public List<EnvioDTO> Listar() {
        return eS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EnvioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody EnvioDTO dto) {
        ModelMapper m = new ModelMapper();
        Envio e = m.map(dto, Envio.class);
        eS.Registrar(e);
    }

    @GetMapping("/{id}")
    public EnvioDTO Listarporid(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        EnvioDTO dto = m.map(eS.listarporid(id), EnvioDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody EnvioDTO dto) {
        ModelMapper m = new ModelMapper();
        Envio e = m.map(dto, Envio.class);
        eS.Modificar(e);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Long id) {
        eS.Eliminar(id);
    }
}

