package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface ServicioPrestadoService {

    List<ServicioPrestadoDTO> getAll();

    List<ServicioPrestadoDTO> getByIdHospital(Long idHospital);

    List<ServicioPrestadoDTO> getByIdHospitalAndIdServicio(Long idHospital, Long idServicio);

    ServicioPrestadoDTO save(ServicioPrestadoDTO servicioPrestadoDTO);

    ServicioPrestadoDTO getByIdHospitalAndIdServicioAndIdMedico(Long idHospital, Long idServicio, Long idMedico);

    List<ServicioPrestadoDTO> getByIdMedico(Long idMedico);

    ServicioPrestadoDTO getById(Long id);
}
