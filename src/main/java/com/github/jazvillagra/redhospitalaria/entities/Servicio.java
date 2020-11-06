package com.github.jazvillagra.redhospitalaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * @author jazvillagra
 */
@Entity
@Table(schema = "public", name = "servicio")
@Getter
@Setter
public class Servicio {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "cod_servicio")
    @NotNull
    private String codServicio;

    @Column(name = "nro_camas_totales")
    @NotNull
    private int nroCamasTotales;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("nombre", nombre)
                .append("codServicio", codServicio)
                .append("nroCamasTotales", nroCamasTotales)
                .toString();
    }
}