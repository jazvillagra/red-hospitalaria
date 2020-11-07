package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.entities.Medico;
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
public class MedicoMapper implements BaseMapper<Medico, MedicoDTO> {

    private final OrikaBeanMapper mapper;

    public MedicoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<MedicoDTO> mapAsList(List<Medico> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicoDTO mapToDto(Medico entity) {
        return mapper.map(entity, MedicoDTO.class);
    }

    @Override
    public Medico mapToEntity(MedicoDTO dto) {
        return mapper.map(dto, Medico.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
