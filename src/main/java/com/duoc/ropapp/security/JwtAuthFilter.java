package com.duoc.ropapp.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain cadena) throws ServletException, IOException {
        String cabecera = request.getHeader("Authorization");
        if (cabecera != null && cabecera.startsWith("Bearer ")) {
            Claims datos = jwtService.leerToken(cabecera.substring(7).trim());
            if (datos != null) {
                var autenticacion = new UsernamePasswordAuthenticationToken(
                        datos.getSubject(), null,
                        List.of(new SimpleGrantedAuthority("ROLE_" + datos.get("rol", String.class))));
                SecurityContextHolder.getContext().setAuthentication(autenticacion);
            }
        }
        cadena.doFilter(request, response);
    }
}