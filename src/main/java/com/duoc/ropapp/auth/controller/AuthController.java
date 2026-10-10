package com.duoc.ropapp.auth.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ropapp.auth.AuthRequest;
import com.duoc.ropapp.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registrar(@RequestBody AuthRequest solicitud) {
        authService.registrar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Usuario registrado"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest solicitud) {
        return ResponseEntity.ok(Map.of("token", authService.login(solicitud)));
    }
}