package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface ServicioRepository extends JpaRepository<Servicio, ServicioDTO> {

    List<Servicio> findAll();

    Servicio findByCodServicio(String codServicio);

    Servicio findById(Long id);
}
