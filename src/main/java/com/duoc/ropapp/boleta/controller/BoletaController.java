package com.duoc.ropapp.boleta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ropapp.boleta.model.Boleta;
import com.duoc.ropapp.boleta.service.BoletaService;

@RestController
@RequestMapping("/api/boleta")
public class BoletaController {

    private final BoletaService boletaService;
    public BoletaController(BoletaService boletaService) {
        this.boletaService = boletaService;
    }

    @GetMapping
    public ResponseEntity<List<Boleta>> findAll() {
        return ResponseEntity.ok(boletaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Boleta>> findById(@PathVariable Integer id) {
        if (boletaService.findById(id).isPresent()) {
            return ResponseEntity.ok(boletaService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
    }}

    @PostMapping
    public ResponseEntity<Boleta> save(@RequestBody Boleta boleta) {
        return ResponseEntity.ok(boletaService.save(boleta));
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        Optional<Boleta> producto = boletaService.findById(id);
        if  (producto.isPresent()) {
            boletaService.deleteById(id);
            return producto.get().getId();
        } else {
            return -1;
        }
    }



}
