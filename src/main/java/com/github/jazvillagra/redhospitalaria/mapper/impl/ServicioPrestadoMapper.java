package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Servicio;
import com.github.jazvillagra.redhospitalaria.entities.ServicioPrestado;
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
public class ServicioPrestadoMapper implements BaseMapper<ServicioPrestado, ServicioPrestadoDTO> {

    private final OrikaBeanMapper mapper;

    public ServicioPrestadoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ServicioPrestadoDTO> mapAsList(List<ServicioPrestado> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioPrestadoDTO mapToDto(ServicioPrestado entity) {
        return mapper.map(entity, ServicioPrestadoDTO.class);
    }

    @Override
    public ServicioPrestado mapToEntity(ServicioPrestadoDTO dto) {
        return mapper.map(dto, ServicioPrestado.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }

}
