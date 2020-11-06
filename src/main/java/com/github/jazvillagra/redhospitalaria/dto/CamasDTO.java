package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class CamasDTO {
    private Long id;
    private Long idHospital;
    private Long idServicio;
    private int cantCamas;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idHospital", idHospital)
                .append("idServicio", idServicio)
                .append("cantCamas", cantCamas)
                .toString();
    }
}
