package com.duoc.ropapp.sucursal.service;

import com.duoc.ropapp.sucursal.model.Sucursal;
import com.duoc.ropapp.sucursal.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {
    private final SucursalRepository sucursalRepository;
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> findById(Integer id) {
        return sucursalRepository.findById(id);
    }


    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteById(Integer id) {
        sucursalRepository.deleteById(id);
    }
}
