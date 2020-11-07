package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.ConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface ConsultaRepository extends JpaRepository<Consulta, ConsultaDTO> {

    Consulta findById(Long id);

    List<Consulta> findByIdPaciente(Long idPaciente);

    List<Consulta> findByIdServicioPrestado(Long idServicioPrestado);
}
