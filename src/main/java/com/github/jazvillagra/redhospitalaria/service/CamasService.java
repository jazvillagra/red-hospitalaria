package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface CamasService {

    List<CamasDTO> getByIdHospital(Long idHospital);

    List<CamasDTO> getByIdServicio(Long idServicio);

    int getCamasByHospital(Long idHospital);

    int getCamasByServicio(Long idServicio);

    CamasDTO getByIdHospitalAndIdServicio(Long idHospital, Long idServicio);

    CamasDTO save(CamasDTO camasDTO);
}
