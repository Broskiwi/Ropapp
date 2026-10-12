package com.duoc.ropapp.sucursal.service;

import com.duoc.ropapp.sucursal.model.Sucursal;
import com.duoc.ropapp.sucursal.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public Sucursal updateSucursal(Sucursal sucursal, Integer id) {
        Optional<Sucursal> ogSucursal =  sucursalRepository.findById(id);
        if (ogSucursal.isEmpty()){
            throw new EntityNotFoundException("Sucursal not found");
        }
        if (Objects.nonNull(sucursal.getNombre()) && !"".equalsIgnoreCase(sucursal.getNombre())) {
            ogSucursal.get().setNombre(sucursal.getNombre());
        }
        if (Objects.nonNull(sucursal.getDireccion()) && !"".equalsIgnoreCase(sucursal.getDireccion())) {
            ogSucursal.get().setDireccion(sucursal.getDireccion());
        }
        if (Objects.nonNull(sucursal.getCiudad()) && !"".equalsIgnoreCase(sucursal.getCiudad())) {
            ogSucursal.get().setCiudad(sucursal.getCiudad());
        }
        return sucursalRepository.save(ogSucursal.get());
    }

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteById(Integer id) {
        sucursalRepository.deleteById(id);
    }
}
