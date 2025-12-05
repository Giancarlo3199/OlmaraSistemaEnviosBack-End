package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IUsuarioRepository;
import pe.com.olmara.sistemaenviosolmaraeducation.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public void Registrar(Usuario u) {
        usuarioRepository.save(u);
    }

    @Override
    public Usuario listarporid(Integer id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public void Modificar(Usuario u) {
        usuarioRepository.save(u);
    }

    @Override
    public void Eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}