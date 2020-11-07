package com.github.jazvillagra.redhospitalaria.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(schema = "public", name = "detalle_consulta")
@Getter
@Setter
public class DetalleConsulta {
    @Id
    @SequenceGenerator(name = "detalle_consulta_id_seq", sequenceName = "detalle_consulta_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "detalle_consulta_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "diagnostico")
    @NotNull
    private String diagnostico;

    @Column(name = "tratamiento")
    @NotNull
    private String tratamiento;

    @Column(name = "paciente_admitido")
    private Boolean pacienteAdmitido;

    @Column(name = "nro_habitacion")
    private int nroHabitacion;

    @Setter(AccessLevel.NONE)
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    public void setFechaAlta(String fechaAlta){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.fechaAlta = LocalDateTime.parse(fechaAlta, formatter);
    }

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
