package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class ServicioPrestadoDTO {
    private Long id;
    private Long idHospital;
    private Long idServicio;
    private Long idMedico;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idHospital", idHospital)
                .append("idServicio", idServicio)
                .append("idMedico", idMedico)
                .toString();
    }
}
