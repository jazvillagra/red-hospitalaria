package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.ConsultaDTO;
import com.github.jazvillagra.redhospitalaria.dto.HistorialMedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.PacienteDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Paciente;
import com.github.jazvillagra.redhospitalaria.mapper.impl.PacienteMapper;
import com.github.jazvillagra.redhospitalaria.repository.PacienteRepository;
import com.github.jazvillagra.redhospitalaria.service.ConsultaService;
import com.github.jazvillagra.redhospitalaria.service.PacienteService;
import com.github.jazvillagra.redhospitalaria.service.ServicioPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private ServicioPrestadoService servicioPrestadoService;

    @Autowired
    private ConsultaService consultaService;

    @Override
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.mapToEntity(pacienteDTO);
        paciente.setNombres(pacienteDTO.getNombres().toUpperCase());
        paciente.setApellidos(pacienteDTO.getApellidos().toUpperCase());
        paciente.setTipoDocumento(pacienteDTO.getTipoDocumento().toUpperCase());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        return pacienteMapper.mapToDto(pacienteRepository.save(paciente));
    }

    @Override
    public PacienteDTO getByCodHistorial(String codHistorial) {
        return pacienteMapper.mapToDto(pacienteRepository.findByCodHistorial(codHistorial));
    }

    @Override
    public PacienteDTO getByTipoDocumentoAndNroDocumento(String tipoDocumento, String nroDocumento) {
        return pacienteMapper.mapToDto(pacienteRepository.findByTipoDocumentoAndNroDocumento(tipoDocumento.toUpperCase(), nroDocumento));
    }

    @Override
    public List<PacienteDTO> getByIdHospitalAndIdServicioAndIdMedico(Long idHospital, Long idServicio, Long idMedico) {
        ServicioPrestadoDTO servicioPrestadoDTO = servicioPrestadoService
                                                    .getByIdHospitalAndIdServicioAndIdMedico(idHospital,
                                                                                            idServicio,
                                                                                            idMedico);
        List<ConsultaDTO> consultas = consultaService.getByIdServicioPrestado(servicioPrestadoDTO.getId());
        List<Paciente> pacientes = new ArrayList<>();
        for(ConsultaDTO consulta : consultas) {
            Paciente paciente = pacienteRepository.findById(consulta.getIdPaciente());
            pacientes.add(paciente);
        }
        return pacienteMapper.mapAsList(pacientes);
    }

    @Override
    public PacienteDTO getByNombreAndApellido(String nombre, String apellido) {
        return pacienteMapper.mapToDto(pacienteRepository.findByNombresAndApellidos(nombre.toUpperCase(),
                                                                                    apellido.toUpperCase()));
    }

    @Override
    public HistorialMedicoDTO getHistorialMedicoByCodHistorial(String codHistorial){
        HistorialMedicoDTO historialMedicoDTO = new HistorialMedicoDTO();
        PacienteDTO paciente = getByCodHistorial(codHistorial);
        historialMedicoDTO.setPaciente(paciente);
        historialMedicoDTO.setConsultas(consultaService.getByIdPaciente(paciente.getId()));
        return historialMedicoDTO;
    }

    @Override
    public void deleteHistorialPaciente(String codHistorial) {
        pacienteRepository.delete(pacienteMapper.mapToEntity(getByCodHistorial(codHistorial)));
    }
}
