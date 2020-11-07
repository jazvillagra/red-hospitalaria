package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jazvillagra
 */
public interface HospitalRepository extends JpaRepository<Hospital, HospitalDTO> {

    List<Hospital> findAll();

    Hospital findById(Long id);

    Hospital findByCodHospital(String codHospital);
}
