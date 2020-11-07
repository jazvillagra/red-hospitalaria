package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ConsultaDTO {
    private Long id;
    private Long idPaciente;
    private Long idServicioPrestado;
    private Long idDetalle;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idPaciente", idPaciente)
                .append("idServicioPrestado", idServicioPrestado)
                .append("idDetalle", idDetalle)
                .toString();
    }
}
