package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.DetalleConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.DetalleConsulta;
import com.github.jazvillagra.redhospitalaria.mapper.impl.DetalleConsultaMapper;
import com.github.jazvillagra.redhospitalaria.repository.DetalleConsultaRepository;
import com.github.jazvillagra.redhospitalaria.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService {
    @Autowired
    private DetalleConsultaRepository detalleConsultaRepository;

    @Autowired
    private DetalleConsultaMapper detalleConsultaMapper;

    @Override
    public DetalleConsultaDTO save(DetalleConsultaDTO detalleConsultaDTO) {
        DetalleConsulta detalleConsulta = detalleConsultaMapper.mapToEntity(detalleConsultaDTO);
        return detalleConsultaMapper.mapToDto(detalleConsultaRepository.save(detalleConsulta));
    }

    @Override
    public List<DetalleConsultaDTO> getAll() {
        return detalleConsultaMapper.mapAsList(detalleConsultaRepository.findAll());
    }

    @Override
    public DetalleConsultaDTO getById(Long id) {
        return detalleConsultaMapper.mapToDto(detalleConsultaRepository.findById(id));
    }

    @Override
    public void deleteDetalle(DetalleConsultaDTO dto) {
        detalleConsultaRepository.deleteById(dto);
    }
}
