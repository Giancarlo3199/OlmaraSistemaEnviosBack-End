package pe.com.olmara.sistemaenviosolmaraeducation.securities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import pe.com.olmara.sistemaenviosolmaraeducation.entities.Usuario;
import pe.com.olmara.sistemaenviosolmaraeducation.repositories.IUsuarioRepository;


import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    @Autowired
    private IUsuarioRepository uR;

    //milisegundos || 18 minutos, le quitamos mil 18 segundos demo
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    //Recuperar nombre de usuario del token jwt
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //Recuperar la fecha de vencimiento del token jwt
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //Para recuperar cualquier información del token necesitaremos la clave secreta
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    //VERIFICAR SI EL TOKEN A EXPIRADO
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Usuario usuario = uR.findOneByUsername(userDetails.getUsername());

        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", usuario.getUsername()); // o usuario.getNombre() si tienes ese campo
        claims.put("role", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining()));
        claims.put("idUsuario", usuario.getId()); // 🔹 Esto es lo que necesitas

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS512.getJcaName())).compact();
    }

    //Validar token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
