package com.github.jazvillagra.redhospitalaria.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "medico")
@Getter
@Setter
public class Medico {

    @Id
    @SequenceGenerator(name = "medico_id_seq", sequenceName = "medico_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "medico_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_documento", length = 10)
    @NotNull
    private String tipoDocumento;

    @Column(name = "nro_documento", length = 10)
    @NotNull
    private String nroDocumento;

    @Column(name = "nombres")
    @NotNull
    private String nombres;

    @Column(name = "apellidos")
    @NotNull
    private String apellidos;

    @Setter(AccessLevel.NONE)
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
    }

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
