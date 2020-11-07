package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;
import com.github.jazvillagra.redhospitalaria.entities.Camas;
import com.github.jazvillagra.redhospitalaria.mapper.impl.CamasMapper;
import com.github.jazvillagra.redhospitalaria.repository.CamasRepository;
import com.github.jazvillagra.redhospitalaria.service.CamasService;
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

    @Override
    public List<CamasDTO> getByIdHospital(Long idHospital) {
        return camasMapper.mapAsList(camasRepository.findByIdHospital(idHospital));
    }

    @Override
    public List<CamasDTO> getByIdServicio(Long idServicio) {
        return camasMapper.mapAsList(camasRepository.findByIdServicio(idServicio));
    }

    @Override
    public int getCamasByHospital(Long idHospital) {
        List<Camas> camasList = camasRepository.findByIdHospital(idHospital);
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
