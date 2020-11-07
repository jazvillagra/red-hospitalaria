package com.github.jazvillagra.redhospitalaria.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author jazvillagra
 */
@Entity
@Table(schema = "public", name = "paciente")
@Getter
@Setter
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_id_seq", sequenceName = "paciente_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "paciente_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_historial")
    @NotNull
    private String codHistorial;

    @Column(name = "nombres")
    @NotNull
    private String nombres;

    @Column(name = "apellidos")
    @NotNull
    private String apellidos;

    @Column(name = "tipo_documento")
    @NotNull
    private String tipoDocumento;

    @Column(name = "nro_documento")
    @NotNull
    private String nroDocumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "datos_adicionales")
    private String datosAdicionales;

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
    }

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
