package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.DetalleConsultaDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface DetalleConsultaService {

    DetalleConsultaDTO save(DetalleConsultaDTO detalleConsultaDTO);

    List<DetalleConsultaDTO> getAll();

    DetalleConsultaDTO getById(Long id);

    void deleteDetalle(DetalleConsultaDTO dto);
}
