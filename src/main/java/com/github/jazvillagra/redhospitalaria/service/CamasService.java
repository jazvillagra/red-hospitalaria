package com.github.jazvillagra.redhospitalaria.service;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface CamasService {

    List<CamasDTO> getByIdHospital(Long idHospital);

    int getByIdServicio(Long idServicio);

    int getCamasByHospital(String codHospital);

    int getCamasByServicio(Long idServicio);

    CamasDTO getByIdHospitalAndIdServicio(Long idHospital, Long idServicio);

    CamasDTO save(CamasDTO camasDTO);

    void actualizarConteoCamas(Long idServicioPrestado);
}
