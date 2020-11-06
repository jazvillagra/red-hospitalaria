package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface MedicoService {

    List<MedicoDTO> getAllMedicos();

    MedicoDTO getByNroDocumento(String nroDocumento);

    MedicoDTO getByNombresApellidos(String nombres, String apellidos);

    MedicoDTO save(MedicoDTO medicoDTO);
}
