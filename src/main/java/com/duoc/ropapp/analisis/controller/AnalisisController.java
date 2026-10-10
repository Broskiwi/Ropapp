package com.duoc.ropapp.analisis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ropapp.analisis.ProductoVendidoDTO;
import com.duoc.ropapp.analisis.VentaMensualDTO;
import com.duoc.ropapp.analisis.service.AnalisisService;

@RestController
@RequestMapping("/api/analisis")
public class AnalisisController {

    private final AnalisisService analisisService;

    public AnalisisController(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    @GetMapping("/tendencia")
    public ResponseEntity<List<VentaMensualDTO>> tendencia() {
        return ResponseEntity.ok(analisisService.tendenciaMensual());
    }

    @GetMapping("/productos-mas-vendidos")
    public ResponseEntity<List<ProductoVendidoDTO>> productosMasVendidos(
            @RequestParam(name = "limite", defaultValue = "5") int limite) {
        return ResponseEntity.ok(analisisService.productosMasVendidos(limite));
    }
}