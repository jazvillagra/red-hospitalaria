package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.ConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.Consulta;
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
public class ConsultaMapper implements BaseMapper<Consulta, ConsultaDTO> {

    private OrikaBeanMapper mapper;

    public ConsultaMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ConsultaDTO> mapAsList(List<Consulta> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultaDTO mapToDto(Consulta entity) {
        return mapper.map(entity, ConsultaDTO.class);
    }

    @Override
    public Consulta mapToEntity(ConsultaDTO dto) {
        return mapper.map(dto, Consulta.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
