package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class HospitalDTO {

    private Long id;
    private String codHospital;
    private String nombre;
    private String ciudad;
    private String telefono;
    private String director;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("codHospital", codHospital)
                .append("nombre", nombre)
                .append("ciudad", ciudad)
                .append("telefono", telefono)
                .append("director", director)
                .toString();
    }
}
