package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.DetalleConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.DetalleConsulta;
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
public class DetalleConsultaMapper implements BaseMapper<DetalleConsulta, DetalleConsultaDTO> {

    private OrikaBeanMapper mapper;

    public DetalleConsultaMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<DetalleConsultaDTO> mapAsList(List<DetalleConsulta> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetalleConsultaDTO mapToDto(DetalleConsulta entity) {
        return mapper.map(entity, DetalleConsultaDTO.class);
    }

    @Override
    public DetalleConsulta mapToEntity(DetalleConsultaDTO dto) {
        return mapper.map(dto, DetalleConsulta.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
