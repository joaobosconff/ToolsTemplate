package jb.estudo.ferramentas.config.security;

import jb.estudo.ferramentas.config.security.filters.AuthenticationFilter;
import jb.estudo.ferramentas.config.security.filters.AuthorizationFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${url.login}")
    private String urlLogin;

    @Autowired
    private AuthenticationConfiguration configuration;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("v1/public/*").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(new AuthenticationFilter(configuration.getAuthenticationManager(), jwtService,urlLogin), UsernamePasswordAuthenticationFilter.class)

                .addFilterAfter(new AuthorizationFilter(userDetailsService,jwtService), UsernamePasswordAuthenticationFilter.class)
                .build();




    }

    }

