package com.ucentral.Escuelabasket.EscuelaBasket.seguridad;

import com.ucentral.Escuelabasket.EscuelaBasket.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SeguridadLogin {

    @Autowired
    @Lazy
    private ServicioUsuarios usuarioServicio;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/Menuadmin").hasRole("ADMINISTRADOR")
                .requestMatchers("/entrenador/**").hasRole("ENTRENADOR")
                .requestMatchers("/representante/**").hasRole("REPRESENTANTE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(customAuthenticationSuccessHandler()); // Usa el manejador personalizado

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"))) {
                    response.sendRedirect("/Menuadmin");
                } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ENTRENADOR"))) {
                    response.sendRedirect("/entrenador/home");
                } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_REPRESENTANTE"))) {
                    response.sendRedirect("/representante/home");
                } else {
                    response.sendRedirect("/"); // Redirige a la página principal o una página de error si el rol no es reconocido
                }
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(usuarioServicio).passwordEncoder(passwordEncoder());
        return auth.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
