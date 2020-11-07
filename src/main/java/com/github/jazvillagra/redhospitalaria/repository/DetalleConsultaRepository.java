package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.DetalleConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.DetalleConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jazvillagra
 */
public interface DetalleConsultaRepository extends JpaRepository<DetalleConsulta, DetalleConsultaDTO> {

    DetalleConsulta findById(Long id);
}
