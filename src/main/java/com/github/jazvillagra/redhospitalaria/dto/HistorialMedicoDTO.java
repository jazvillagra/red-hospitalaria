package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistorialMedicoDTO {
    private PacienteDTO paciente;
    private List<ConsultaDTO> consultas;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("paciente", paciente)
                .append("consultas", consultas)
                .toString();
    }
}
