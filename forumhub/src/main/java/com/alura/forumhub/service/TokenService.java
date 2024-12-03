package com.alura.forumhub.service;

import com.alura.forumhub.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(usuario.getId().toString()) // ID do usuário
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expiração em 1 dia
                .signWith(SignatureAlgorithm.HS256, secret) // Algoritmo de assinatura
                .compact();
    }
}
