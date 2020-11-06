package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedicoRepository extends JpaRepository<Medico, MedicoDTO> {

    List<Medico> findAll();

    Medico findByNroDocumento(String nroDocumento);

    Medico findByNombresAndApellidos(String nombres, String Apellidos);

    Medico findById(Long id);
}
