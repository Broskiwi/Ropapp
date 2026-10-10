package com.duoc.ropapp.analisis.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.duoc.ropapp.analisis.ProductoVendidoDTO;
import com.duoc.ropapp.analisis.VentaMensualDTO;
import com.duoc.ropapp.boleta.model.Boleta;

public interface AnalisisRepository extends Repository<Boleta, Integer> {

    @Query("""
            SELECT new com.duoc.ropapp.analisis.VentaMensualDTO(year(b.fecha), month(b.fecha), COUNT(b), SUM(b.total))
            FROM Boleta b
            GROUP BY year(b.fecha), month(b.fecha)
            ORDER BY year(b.fecha), month(b.fecha)
            """)
    List<VentaMensualDTO> ventasPorMes();

    @Query("""
            SELECT new com.duoc.ropapp.analisis.ProductoVendidoDTO(pr.nombre, COUNT(pr))
            FROM Boleta b JOIN b.pedidos p JOIN p.productos pr
            GROUP BY pr.nombre
            ORDER BY COUNT(pr) DESC, pr.nombre
            """)
    List<ProductoVendidoDTO> productosMasVendidos(Pageable limite);
}