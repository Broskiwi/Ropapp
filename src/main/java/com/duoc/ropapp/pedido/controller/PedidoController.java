package com.duoc.ropapp.pedido.controller;

import com.duoc.ropapp.pedido.model.Pedido;
import com.duoc.ropapp.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> findById(@PathVariable Integer id) {
        if (pedidoService.findById(id).isPresent()) {
            return ResponseEntity.ok(pedidoService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
    }}

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        Optional<Pedido> producto = pedidoService.findById(id);
        if  (producto.isPresent()) {
            pedidoService.deleteById(id);
            return producto.get().getId();
        } else {
            return -1;
        }
    }



}
