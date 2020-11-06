package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioMedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Medico;
import com.github.jazvillagra.redhospitalaria.entities.ServicioPrestado;
import com.github.jazvillagra.redhospitalaria.mapper.impl.MedicoMapper;
import com.github.jazvillagra.redhospitalaria.repository.MedicoRepository;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import com.github.jazvillagra.redhospitalaria.service.MedicoService;
import com.github.jazvillagra.redhospitalaria.service.ServicioPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jazvillagra
 */
@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private ServicioPrestadoService servicioPrestadoService;

    @Autowired
    private HospitalService hospitalService;

    @Override
    public List<MedicoDTO> getAllMedicos() {
        return medicoMapper.mapAsList(medicoRepository.findAll());
    }

    @Override
    public MedicoDTO getByNroDocumento(String nroDocumento) {
        return medicoMapper.mapToDto(medicoRepository.findByNroDocumento(nroDocumento));
    }

    @Override
    public MedicoDTO getByNombresApellidos(String nombres, String apellidos) {
        return medicoMapper.mapToDto(medicoRepository.findByNombresAndApellidos(nombres, apellidos));
    }

    @Override
    public MedicoDTO save(MedicoDTO medicoDTO) {

        /* Saving this just in case it´s needed
         LocalDate fecNacimiento = LocalDate.parse(medicoDTO.getFechaNacimiento());

        Medico medico = medicoMapper.mapToEntity(medicoDTO);
        medico.setFechaNacimiento(fecNacimiento);
        */
        //este es el entity que se guarda finalmente en la bd

        Medico entity = medicoRepository.save(medicoMapper.mapToEntity(medicoDTO));

        saveServiciosMedico(medicoDTO, entity);
        // se mapea lo guardado en la bd a un dto para mostrar los datos correctos
        MedicoDTO response = medicoMapper.mapToDto(entity);

        List<ServicioPrestadoDTO> serviciosPrestadosPorMedico = servicioPrestadoService.getByIdMedico(entity.getId());
        if(!serviciosPrestadosPorMedico.isEmpty()){
            List<ServicioMedicoDTO> servicioMedicoDTOS = new ArrayList<>();
            for(ServicioPrestadoDTO prestadoDto : serviciosPrestadosPorMedico){
                ServicioMedicoDTO dto = new ServicioMedicoDTO();
                dto.setCodHospital(hospitalService.getById(prestadoDto.getIdMedico()).getCodHospital());
                dto.setIdServicio(prestadoDto.getIdServicio());
                servicioMedicoDTOS.add(dto);
            }
            response.setServicios(servicioMedicoDTOS);
        }else{
            response.setServicios(null);
        }
        return response;
    }

    private void saveServiciosMedico(MedicoDTO medicoDTO, Medico entity) {
        for(ServicioMedicoDTO dto : medicoDTO.getServicios()){
            Long idHospital = hospitalService.getByCodHospital(dto.getCodHospital()).getId();
            if(servicioPrestadoService.getByIdHospitalAndIdServicioAndIdMedico(idHospital, dto.getIdServicio(), entity.getId()) == null){
                ServicioPrestadoDTO servicioPrestadoDTO = new ServicioPrestadoDTO();
                servicioPrestadoDTO.setIdHospital(idHospital);
                servicioPrestadoDTO.setIdServicio(dto.getIdServicio());
                servicioPrestadoDTO.setIdMedico(entity.getId());
                servicioPrestadoService.save(servicioPrestadoDTO);
            }
        }
    }
}
