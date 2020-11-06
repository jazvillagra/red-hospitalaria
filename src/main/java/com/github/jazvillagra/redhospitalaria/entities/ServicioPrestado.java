package com.github.jazvillagra.redhospitalaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "servicio_prestado")
@Getter
@Setter
public class ServicioPrestado {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "id_hospital")
    @NotNull
    private Long idHospital;

    @Column(name = "id_servicio")
    @NotNull
    private Long idServicio;

    @Column(name = "id_medico")
    @NotNull
    private Long idMedico;
}
