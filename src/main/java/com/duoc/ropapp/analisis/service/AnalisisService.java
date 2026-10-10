package com.duoc.ropapp.analisis.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.ropapp.analisis.ProductoVendidoDTO;
import com.duoc.ropapp.analisis.VentaMensualDTO;
import com.duoc.ropapp.analisis.repository.AnalisisRepository;

@Service
public class AnalisisService {

    private final AnalisisRepository analisisRepository;

    public AnalisisService(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    public List<VentaMensualDTO> tendenciaMensual() {
        return analisisRepository.ventasPorMes();
    }

    public List<ProductoVendidoDTO> productosMasVendidos(int limite) {
        if (limite < 1 || limite > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El límite debe estar entre 1 y 50");
        }
        return analisisRepository.productosMasVendidos(PageRequest.of(0, limite));
    }
}