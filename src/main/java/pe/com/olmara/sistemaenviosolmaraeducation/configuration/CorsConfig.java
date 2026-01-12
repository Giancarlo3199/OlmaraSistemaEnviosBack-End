package pe.com.olmara.sistemaenviosolmaraeducation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // NO usar "*" si usas credentials
        config.setAllowCredentials(false);

        // Frontend LOCAL
        config.addAllowedOrigin("http://localhost:4200");

        // Frontend PRODUCCIÓN
        config.addAllowedOrigin("https://olmarasistemaenviosfront-end-production.up.railway.app");

        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
