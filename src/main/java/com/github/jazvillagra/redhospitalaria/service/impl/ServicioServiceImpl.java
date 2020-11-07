package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.entities.Servicio;
import com.github.jazvillagra.redhospitalaria.mapper.impl.ServicioMapper;
import com.github.jazvillagra.redhospitalaria.repository.ServicioRepository;
import com.github.jazvillagra.redhospitalaria.service.CamasService;
import com.github.jazvillagra.redhospitalaria.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repository;

    @Autowired
    private ServicioMapper mapper;

    @Autowired
    private CamasService camasService;

    @Override
    public List<ServicioDTO> getAllServicios() {
        return mapper.mapAsList(repository.findAll());
    }

    @Override
    public ServicioDTO save(ServicioDTO servicioDTO) {
        Servicio entity = mapper.mapToEntity(servicioDTO);
        entity.setNroCamasTotales(camasService.getCamasByServicio(servicioDTO.getId()));
        return mapper.mapToDto(repository.save(entity));
    }

    @Override
    public ServicioDTO getByCodServicio(String codServicio) {
        return mapper.mapToDto(repository.findByCodServicio(codServicio));
    }
}
