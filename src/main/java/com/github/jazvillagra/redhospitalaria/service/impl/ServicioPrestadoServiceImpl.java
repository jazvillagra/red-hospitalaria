package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Medico;
import com.github.jazvillagra.redhospitalaria.entities.ServicioPrestado;
import com.github.jazvillagra.redhospitalaria.mapper.impl.ServicioPrestadoMapper;
import com.github.jazvillagra.redhospitalaria.repository.ServicioPrestadoRepository;
import com.github.jazvillagra.redhospitalaria.service.ServicioPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class ServicioPrestadoServiceImpl implements ServicioPrestadoService {

    @Autowired
    private ServicioPrestadoRepository repository;

    @Autowired
    private ServicioPrestadoMapper mapper;

    @Override
    public List<ServicioPrestadoDTO> getAll() {
        return mapper.mapAsList(repository.findAll());
    }

    @Override
    public List<ServicioPrestadoDTO> getByIdHospital(Long idHospital) {
        return mapper.mapAsList(repository.findByIdHospital(idHospital));
    }

    @Override
    public List<ServicioPrestadoDTO> getByIdHospitalAndIdServicio(Long idHospital, Long idServicio) {
        return mapper.mapAsList(repository.findByIdHospitalAndIdServicio(idHospital, idServicio));
    }

    @Override
    public ServicioPrestadoDTO save(ServicioPrestadoDTO servicioPrestadoDTO) {
        ServicioPrestado entity = mapper.mapToEntity(servicioPrestadoDTO);
        return mapper.mapToDto(repository.save(entity));
    }

    @Override
    public ServicioPrestadoDTO getByIdHospitalAndIdServicioAndIdMedico(Long idHospital, Long idServicio, Long idMedico) {
        return mapper.mapToDto(repository.findByIdHospitalAndIdServicioAndIdMedico(idHospital, idServicio, idMedico));
    }

    @Override
    public List<ServicioPrestadoDTO> getByIdMedico(Long idMedico) {
        List<ServicioPrestado> servicioPrestados = repository.findByIdMedico(idMedico);
        return mapper.mapAsList(servicioPrestados);
    }

    @Override
    public ServicioPrestadoDTO getById(Long id) {
        return mapper.mapToDto(repository.findById(id));
    }
}
