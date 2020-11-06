package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface ServicioService {

    List<ServicioDTO> getAllServicios();

    ServicioDTO save(ServicioDTO servicioDTO);

    ServicioDTO getByCodServicio(String codServicio);
}
