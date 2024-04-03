package jb.estudo.ferramentas.config.security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Component
public class JWTService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
             return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(username)
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plus(expiration, ChronoUnit.MILLIS)
                .toInstant(ZoneOffset.of("-03:00"));
    }


}
