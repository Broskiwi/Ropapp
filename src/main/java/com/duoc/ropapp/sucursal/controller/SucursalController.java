package com.duoc.ropapp.sucursal.controller;

import com.duoc.ropapp.sucursal.model.Sucursal;
import com.duoc.ropapp.sucursal.service.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> findAll() {
        return ResponseEntity.ok(sucursalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sucursal>> findById(@PathVariable Integer id) {
        if (sucursalService.findById(id).isPresent()) {
            return ResponseEntity.ok(sucursalService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }}

    @PostMapping
    public ResponseEntity<Sucursal> save(@RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.save(sucursal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> update(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.updateSucursal(sucursal, id));
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        Optional<Sucursal> sucursal = sucursalService.findById(id);
        if  (sucursal.isPresent()) {
            sucursalService.deleteById(id);
            return sucursal.get().getId();
        } else {
            return -1;
        }
    }



}
