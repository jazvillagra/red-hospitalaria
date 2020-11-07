package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.ConsultaDTO;
import com.github.jazvillagra.redhospitalaria.entities.Consulta;
import com.github.jazvillagra.redhospitalaria.mapper.impl.ConsultaMapper;
import com.github.jazvillagra.redhospitalaria.repository.ConsultaRepository;
import com.github.jazvillagra.redhospitalaria.service.CamasService;
import com.github.jazvillagra.redhospitalaria.service.ConsultaService;
import com.github.jazvillagra.redhospitalaria.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Autowired
    private DetalleConsultaService detalleConsultaService;

    @Autowired
    private CamasService camasService;

    @Override
    public ConsultaDTO save(ConsultaDTO consultaDTO) {
        detalleConsultaService.save(consultaDTO.getDetalle());
        Consulta consulta = consultaMapper.mapToEntity(consultaDTO);
        consulta.setFechaConsulta(consultaDTO.getFechaConsulta());
        consulta.setIdDetalle(consultaDTO.getDetalle().getId());
        camasService.actualizarConteoCamas(consultaDTO.getIdServicioPrestado());
        return consultaMapper.mapToDto(consultaRepository.save(consulta));
    }

    @Override
    public List<ConsultaDTO> getByIdPaciente(Long idPaciente) {
        List<ConsultaDTO> consultas = new ArrayList<>();
        for(Consulta consulta : consultaRepository.findByIdPaciente(idPaciente)){
            ConsultaDTO consultaDTO = consultaMapper.mapToDto(consulta);
            consultaDTO.setDetalle(detalleConsultaService.getById(consulta.getIdDetalle()));
            consultas.add(consultaDTO);
        }
        return consultas;
    }

    @Override
    public ConsultaDTO getById(Long id) {
        Consulta consulta = consultaRepository.findById(id);
        ConsultaDTO consultaDTO = consultaMapper.mapToDto(consulta);
        consultaDTO.setDetalle(detalleConsultaService.getById(consulta.getIdDetalle()));
        return consultaDTO;
    }

    @Override
    public List<ConsultaDTO> getByIdServicioPrestado(Long idServicioPrestado) {
        List<ConsultaDTO> consultas = new ArrayList<>();
        for(Consulta consulta : consultaRepository.findByIdServicioPrestado(idServicioPrestado)){
            ConsultaDTO consultaDTO = consultaMapper.mapToDto(consulta);
            consultaDTO.setDetalle(detalleConsultaService.getById(consulta.getIdDetalle()));
            consultas.add(consultaDTO);
        }
        return consultas;
    }

    @Override
    public void deleteConsulta(Long idConsulta) {
        ConsultaDTO consulta = getById(idConsulta);
        detalleConsultaService.deleteDetalle(consulta.getDetalle());
        consultaRepository.delete(consultaMapper.mapToEntity(consulta));
    }
}
