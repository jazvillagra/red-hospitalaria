package com.github.jazvillagra.redhospitalaria.mapper.impl;

import com.github.jazvillagra.redhospitalaria.dto.PacienteDTO;
import com.github.jazvillagra.redhospitalaria.entities.Paciente;
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
public class PacienteMapper implements BaseMapper<Paciente, PacienteDTO> {

    private OrikaBeanMapper mapper;

    public PacienteMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<PacienteDTO> mapAsList(List<Paciente> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO mapToDto(Paciente entity) {
        return mapper.map(entity, PacienteDTO.class);
    }

    @Override
    public Paciente mapToEntity(PacienteDTO dto) {
        return mapper.map(dto, Paciente.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
