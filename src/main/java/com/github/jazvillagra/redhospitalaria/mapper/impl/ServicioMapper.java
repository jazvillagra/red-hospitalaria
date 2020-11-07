package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.entities.Servicio;
import com.github.jazvillagra.redhospitalaria.mapper.BaseMapper;
import com.github.jazvillagra.redhospitalaria.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jazvillagra
 */
@Component
public class ServicioMapper implements BaseMapper<Servicio, ServicioDTO> {

    private final OrikaBeanMapper mapper;

    public ServicioMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ServicioDTO> mapAsList(List<Servicio> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDTO mapToDto(Servicio entity) {
        return mapper.map(entity, ServicioDTO.class);
    }

    @Override
    public Servicio mapToEntity(ServicioDTO dto) {
        return mapper.map(dto, Servicio.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
