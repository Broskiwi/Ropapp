package com.duoc.ropapp.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.duoc.ropapp.auth.model.Usuario;
import com.duoc.ropapp.auth.repository.UsuarioRepository;

@Component
public class DatosIniciales implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DatosIniciales(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!usuarioRepository.existsByEmail("admin@ropapp.cl")) {
            Usuario admin = new Usuario();
            admin.setEmail("admin@ropapp.cl");
            admin.setPassword(passwordEncoder.encode("Admin123!"));
            admin.setRol("ADMIN");
            usuarioRepository.save(admin);
        }
    }
}