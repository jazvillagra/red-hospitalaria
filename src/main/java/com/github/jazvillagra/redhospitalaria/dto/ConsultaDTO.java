package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class ConsultaDTO {
    private Long id;
    private Long idPaciente;
    private Long idServicioPrestado;
    private String fechaConsulta;
    private DetalleConsultaDTO detalle;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idPaciente", idPaciente)
                .append("idServicioPrestado", idServicioPrestado)
                .append("fechaConsulta", fechaConsulta)
                .append("detalle", detalle)
                .toString();
    }
}
