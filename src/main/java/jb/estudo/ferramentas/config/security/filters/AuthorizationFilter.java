package jb.estudo.ferramentas.config.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jb.estudo.ferramentas.config.security.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static jb.estudo.ferramentas.config.security.SecurityConstants.*;

@AllArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private UserDetailsService userDetailService;

    private JWTService jwtService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER);

        if (!ObjectUtils.isEmpty(header) && header.startsWith(TOKEN_PREFIX)) {
            String token = header.replace(TOKEN_PREFIX, EMPTY);
            UsernamePasswordAuthenticationToken auth = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        String username = jwtService.validateToken(token);
        UserDetails user = userDetailService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());


    }
}

