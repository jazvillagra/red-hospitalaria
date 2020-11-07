package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.PacienteDTO;
import com.github.jazvillagra.redhospitalaria.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jazvillagra
 */
public interface PacienteRepository extends JpaRepository<Paciente, PacienteDTO> {

    Paciente findByTipoDocumentoAndNroDocumento(String tipoDocumento, String nroDocumento);

    Paciente findByNombresAndApellidos(String nombres, String Apellidos);

    Paciente findByCodHistorial(String codHistorial);
}
