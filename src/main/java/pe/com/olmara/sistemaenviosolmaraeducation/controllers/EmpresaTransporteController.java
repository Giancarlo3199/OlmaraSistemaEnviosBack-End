package pe.com.olmara.sistemaenviosolmaraeducation.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.olmara.sistemaenviosolmaraeducation.dtos.EmpresaTransporteDTO;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.EmpresaTransporte;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IEmpresaTransporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresa-transporte")
public class EmpresaTransporteController {

    @Autowired
    private IEmpresaTransporteService eS;

    @GetMapping
    public List<EmpresaTransporteDTO> Listar() {
        return eS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EmpresaTransporteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody EmpresaTransporteDTO dto) {
        ModelMapper m = new ModelMapper();
        EmpresaTransporte e = m.map(dto, EmpresaTransporte.class);
        eS.Registrar(e);
    }

    @GetMapping("/{id}")
    public EmpresaTransporteDTO Listarporid(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        EmpresaTransporteDTO dto = m.map(eS.listarporid(id), EmpresaTransporteDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody EmpresaTransporteDTO dto) {
        ModelMapper m = new ModelMapper();
        EmpresaTransporte e = m.map(dto, EmpresaTransporte.class);
        eS.Modificar(e);
    }

    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") Integer id) {
        eS.Eliminar(id);
    }
}

