package com.SoulCode.Services.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils { // gerenciar e gerar tokens || privacidade de informação
    @Value("${jwt.secret}") // geração de senha de tokens para privacidade da aplicação e deve ser mantido sob sigilo
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String email){
        return JWT.create().withSubject(email).withExpiresAt(
                new Date(System.currentTimeMillis() + expiration)).sign(Algorithm.HMAC512(secret)
                // função que cria o jwt, pega a data atual mais a data de expiração e no final assina o algoritmo
        );
    }
    public String getLogin(String token){
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getSubject();
        // retorno do JWT decodificado
    }
}
