package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.HistorialMedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.PacienteDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface PacienteService {

    PacienteDTO save(PacienteDTO pacienteDTO);

    PacienteDTO getByCodHistorial(String codHistorial);

    PacienteDTO getByTipoDocumentoAndNroDocumento(String tipoDocumento, String nroDocumento);

    List<PacienteDTO> getByIdHospitalAndIdServicioAndIdMedico(Long idHospital, Long idServicio, Long idMedico);

    PacienteDTO getByNombreAndApellido(String nombre, String apellido);

    void deleteHistorialPaciente(String codHistorial);

    HistorialMedicoDTO getHistorialMedicoByCodHistorial(String codHistorial);
}
