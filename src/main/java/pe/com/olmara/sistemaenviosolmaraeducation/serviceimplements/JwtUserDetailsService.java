package pe.com.olmara.sistemaenviosolmaraeducation.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IUsuarioRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe: ", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        roles.add(new SimpleGrantedAuthority(user.getRol().getNombreRol()));

        // OJO: AQUI SE USA EL MODELS USUARIO, no DTO
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getActivo(),  // enabled
                true,              // accountNonExpired
                true,              // credentialsNonExpired
                true,              // accountNonLocked
                roles
        );
    }
}
