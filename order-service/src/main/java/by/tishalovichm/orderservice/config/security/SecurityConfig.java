package by.tishalovichm.orderservice.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String ADMIN = "admin";

    private final JwtConverter jwtConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            @Value("${order-api.base-url.name}") String baseUrl) throws Exception {

        http.authorizeHttpRequests((authz) ->
                authz.requestMatchers(HttpMethod.GET, baseUrl + "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, baseUrl + "/**").hasRole(ADMIN)
                        .anyRequest().authenticated());

        http.sessionManagement(sess -> sess.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));

        http.oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        return http.build();
    }

}
