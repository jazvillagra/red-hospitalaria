package com.github.jazvillagra.redhospitalaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author jazvillagra
 */

@Entity
@Table(schema = "public", name = "hospital")
@Getter
@Setter
public class Hospital {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_hospital")
    private String codHospital;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "director")
    private String director;


}
