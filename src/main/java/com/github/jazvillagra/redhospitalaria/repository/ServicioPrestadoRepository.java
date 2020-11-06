package com.github.jazvillagra.redhospitalaria.repository;

import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.ServicioPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jazvillagra
 */
@Component
public interface ServicioPrestadoRepository extends JpaRepository<ServicioPrestado, ServicioPrestadoDTO> {

    List<ServicioPrestado> findAll();

    ServicioPrestado findById(Long id);

    List<ServicioPrestado> findByIdHospital(Long idHospital);

    List<ServicioPrestado> findByIdHospitalAndIdServicio(Long idHospital, Long idServicio);

    ServicioPrestado findByIdHospitalAndIdServicioAndIdMedico(Long idHospital, Long idServicio, Long idMedico);

    List<ServicioPrestado> findByIdMedico(Long idMedico);
}
