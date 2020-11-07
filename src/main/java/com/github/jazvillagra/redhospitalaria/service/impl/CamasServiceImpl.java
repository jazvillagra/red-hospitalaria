package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;
import com.github.jazvillagra.redhospitalaria.entities.Camas;
import com.github.jazvillagra.redhospitalaria.mapper.impl.CamasMapper;
import com.github.jazvillagra.redhospitalaria.repository.CamasRepository;
import com.github.jazvillagra.redhospitalaria.service.CamasService;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class CamasServiceImpl implements CamasService {
    @Autowired
    private CamasRepository camasRepository;

    @Autowired
    private CamasMapper camasMapper;

    @Autowired
    private HospitalService hospitalService;

    @Override
    public List<CamasDTO> getByIdHospital(Long idHospital) {
        return camasMapper.mapAsList(camasRepository.findByIdHospital(idHospital));
    }

    @Override
    public int getByIdServicio(Long idServicio) {
        int cantCamasDisponibles = 0;
        for(Camas camas : camasRepository.findByIdServicio(idServicio)){
            cantCamasDisponibles = cantCamasDisponibles + camas.getCantCamas();
        }
        return cantCamasDisponibles;
    }

    @Override
    public int getCamasByHospital(String codHospital) {
        List<Camas> camasList = camasRepository.findByIdHospital(hospitalService.getByCodHospital(codHospital).getId());
        int conteoCamas = 0;
        for(Camas c : camasList){
            conteoCamas = conteoCamas + c.getCantCamas();
        }
        return conteoCamas;
    }

    @Override
    public int getCamasByServicio(Long idServicio) {
        List<Camas> camasList = camasRepository.findByIdServicio(idServicio);
        int conteoCamas = 0;
        for(Camas c : camasList){
            conteoCamas = conteoCamas + c.getCantCamas();
        }
        return conteoCamas;
    }

    @Override
    public CamasDTO getByIdHospitalAndIdServicio(Long idHospital, Long idServicio) {
        return camasMapper.mapToDto(camasRepository.findByIdHospitalAndIdServicio(idHospital, idServicio));
    }

    @Override
    public CamasDTO save(CamasDTO camas) {
        Camas entity = camasMapper.mapToEntity(camas);
        return camasMapper.mapToDto(camasRepository.save(entity));
    }
}
