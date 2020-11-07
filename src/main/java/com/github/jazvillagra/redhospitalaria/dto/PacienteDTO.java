package com.github.jazvillagra.redhospitalaria.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jazvillagra
 */
@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String codHistorial;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String nroDocumento;
    private String fechaNacimiento;
    private String datosAdicionales;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("codHistorial", codHistorial)
                .append("nombres", nombres)
                .append("apellidos", apellidos)
                .append("tipoDocumento", tipoDocumento)
                .append("nroDocumento", nroDocumento)
                .append("fechaNacimiento", fechaNacimiento)
                .append("datosAdicionales", datosAdicionales)
                .toString();
    }
}
