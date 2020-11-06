package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;
import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.entities.Camas;
import com.github.jazvillagra.redhospitalaria.entities.Hospital;
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
public class CamasMapper implements BaseMapper<Camas, CamasDTO> {

    private OrikaBeanMapper mapper;

    public CamasMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<CamasDTO> mapAsList(List<Camas> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CamasDTO mapToDto(Camas entity) {
        return mapper.map(entity, CamasDTO.class);
    }

    @Override
    public Camas mapToEntity(CamasDTO dto) {
        return mapper.map(dto, Camas.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
