package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.entities.Hospital;
import com.github.jazvillagra.redhospitalaria.mapper.impl.HospitalMapper;
import com.github.jazvillagra.redhospitalaria.repository.HospitalRepository;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository repository;

    @Autowired
    private HospitalMapper mapper;

    @Override
    public List<HospitalDTO> getAllHospitales() {
        return mapper.mapAsList(repository.findAll());
    }

    @Override
    public HospitalDTO save(HospitalDTO hospitalDTO) {
        Hospital hospital = mapper.mapToEntity(hospitalDTO);
        return mapper.mapToDto(repository.save(hospital));
    }

    @Override
    public HospitalDTO getByCodHospital(String codHospital) {
        return mapper.mapToDto(repository.findByCodHospital(codHospital));
    }
}
