package com.duoc.ropapp.boleta.repository;

import com.duoc.ropapp.boleta.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
}
