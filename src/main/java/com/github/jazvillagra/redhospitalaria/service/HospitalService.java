package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface HospitalService {

    List<HospitalDTO> getAllHospitales();

    HospitalDTO save(HospitalDTO hospitalDTO);

    HospitalDTO getByCodHospital(String codHospital);

    HospitalDTO getById(Long idHospital);
}
