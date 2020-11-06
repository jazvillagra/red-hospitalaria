package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class MedicoDTO {
    private Long id;
    private String tipoDocumento;
    private String nroDocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private List<ServicioMedicoDTO> servicios;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("tipoDocumento", tipoDocumento)
                .append("nroDocumento", nroDocumento)
                .append("nombres", nombres)
                .append("apellidos", apellidos)
                .append("fechaNacimiento", fechaNacimiento)
                .toString();
    }
}
