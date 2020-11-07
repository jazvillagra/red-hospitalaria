package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.ConsultaDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface ConsultaService {

    ConsultaDTO save(ConsultaDTO consultaDTO);

    List<ConsultaDTO> getByIdPaciente(Long idPaciente);

    ConsultaDTO getById(Long id);

    List<ConsultaDTO> getByIdServicioPrestado(Long idServicioPrestado);

    void deleteConsulta(Long idConsulta);
}
