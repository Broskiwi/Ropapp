package com.duoc.ropapp.boleta.service;

import com.duoc.ropapp.boleta.model.Boleta;
import com.duoc.ropapp.boleta.repository.BoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public BoletaService(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    public List<Boleta> findAll() {
        return boletaRepository.findAll();
    }

    public Optional<Boleta> findById(int id){
        return boletaRepository.findById(id);
    }
    public Boleta save(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    public void  deleteById(int id) {
        boletaRepository.deleteById(id);
    }

}
