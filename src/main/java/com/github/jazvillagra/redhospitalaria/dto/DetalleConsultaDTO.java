package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class DetalleConsultaDTO {

    private Long id;
    private String diagnostico;
    private String tratamiento;
    private Boolean pacienteAdmitido;
    private int nroHabitacion;
    private LocalDateTime fechaAlta;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("diagnostico", diagnostico)
                .append("tratamiento", tratamiento)
                .append("pacienteAdmitido", pacienteAdmitido)
                .append("nroHabitacion", nroHabitacion)
                .append("fechaAlta", fechaAlta)
                .toString();
    }
}
