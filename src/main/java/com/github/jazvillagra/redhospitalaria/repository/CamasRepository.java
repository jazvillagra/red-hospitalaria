package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;
import com.github.jazvillagra.redhospitalaria.entities.Camas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jazvillagra
 */
@Component
public interface CamasRepository extends JpaRepository<Camas, CamasDTO> {

    List<Camas> findByIdHospital(Long idHospital);

    Camas findByIdHospitalAndIdServicio(Long idHospital, Long idServicio);

    List<Camas> findByIdServicio(Long idServicio);

}
