package com.github.jazvillagra.redhospitalaria.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jvillagra
 */
@Entity
@Table(schema = "public", name = "consulta")
@Getter
@Setter
public class Consulta {

    @Id
    @SequenceGenerator(name = "consulta_id_seq", sequenceName = "consulta_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "consulta_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_paciente")
    @NotNull
    private Long idPaciente;

    @Column(name = "id_servicio_prestado")
    private Long idServicioPrestado;

    @Column(name = "id_detalle")
    private Long idDetalle;

    @Setter(AccessLevel.NONE)
    @Column(name = "fecha_consulta")
    private LocalDateTime fechaConsulta;

    public void setFechaConsulta(String fechaConsulta){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.fechaConsulta = LocalDateTime.parse(fechaConsulta, formatter);
    }
    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idPaciente", idPaciente)
                .append("idServicioPrestado", idServicioPrestado)
                .append("idDetalle", idDetalle)
                .append("fechaConsulta", fechaConsulta)
                .toString();
    }
}
