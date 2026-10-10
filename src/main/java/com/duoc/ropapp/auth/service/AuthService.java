package com.duoc.ropapp.auth.service;

import com.duoc.ropapp.security.JwtService;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.ropapp.auth.AuthRequest;
import com.duoc.ropapp.auth.model.Usuario;
import com.duoc.ropapp.auth.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void registrar(AuthRequest solicitud) {
        if (solicitud.email() == null || solicitud.email().isBlank()
                || solicitud.password() == null || solicitud.password().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El email es obligatorio y la contraseña debe tener al menos 6 caracteres");
        }
        String email = solicitud.email().trim().toLowerCase();
        if (usuarioRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya está registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(solicitud.password()));
        usuario.setRol("CLIENTE");
        usuarioRepository.save(usuario);
    }

    public String login(AuthRequest solicitud) {
        if (solicitud.email() == null || solicitud.password() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email y contraseña son obligatorios");
        }
        Usuario usuario = usuarioRepository.findByEmail(solicitud.email().trim().toLowerCase())
                .filter(u -> passwordEncoder.matches(solicitud.password(), u.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                        "Email o contraseña incorrectos"));
        return jwtService.generarToken(usuario.getEmail(), usuario.getRol());
    }
}