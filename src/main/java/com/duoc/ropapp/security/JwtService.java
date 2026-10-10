package com.duoc.ropapp.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey clave;
    private final long expiracionMs;

    public JwtService(@Value("${ropapp.jwt.secret}") String secreto,
                      @Value("${ropapp.jwt.expiration-ms}") long expiracionMs) {
        this.clave = Keys.hmacShaKeyFor(secreto.getBytes(StandardCharsets.UTF_8));
        this.expiracionMs = expiracionMs;
    }

    public String generarToken(String email, String rol) {
        Date ahora = new Date();
        return Jwts.builder()
                .subject(email)
                .claim("rol", rol)
                .issuedAt(ahora)
                .expiration(new Date(ahora.getTime() + expiracionMs))
                .signWith(clave)
                .compact();
    }

    public Claims leerToken(String token) {
        try {
            return Jwts.parser().verifyWith(clave).build().parseSignedClaims(token).getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}