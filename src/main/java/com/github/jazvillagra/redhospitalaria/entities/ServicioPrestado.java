package com.github.jazvillagra.redhospitalaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "servicio_prestado")
@Getter
@Setter
public class ServicioPrestado {
    @Id
    @SequenceGenerator(name = "servicio_prestado_id_seq", sequenceName = "servicio_prestado_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "servicio_prestado_id_seq")
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
