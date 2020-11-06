package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class ServicioDTO {

    private Long id;
    private String nombre;
    private String codServicio;
    private int nroCamasTotales;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("nombre", nombre)
                .append("codServicio", codServicio)
                .append("nroCamasTotales", nroCamasTotales)
                .toString();
    }
}
