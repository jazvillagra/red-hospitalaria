package com.github.jazvillagra.redhospitalaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "camas")
@Getter
@Setter
public class Camas {

    @Id
    @SequenceGenerator(name = "camas_id_seq", sequenceName = "camas_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "camas_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_hospital")
    @NotNull
    private Long idHospital;

    @Column(name = "id_servicio")
    @NotNull
    private Long idServicio;

    @Column(name = "cant_camas")
    @NotNull
    private int cantCamas;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("idHospital", idHospital)
                .append("idServicio", idServicio)
                .append("cantCamas", cantCamas)
                .toString();
    }
}
