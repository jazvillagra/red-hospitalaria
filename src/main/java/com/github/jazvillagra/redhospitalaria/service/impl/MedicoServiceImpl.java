package com.github.jazvillagra.redhospitalaria.service.impl;

import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioMedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioPrestadoDTO;
import com.github.jazvillagra.redhospitalaria.entities.Medico;
import com.github.jazvillagra.redhospitalaria.mapper.impl.MedicoMapper;
import com.github.jazvillagra.redhospitalaria.repository.MedicoRepository;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import com.github.jazvillagra.redhospitalaria.service.MedicoService;
import com.github.jazvillagra.redhospitalaria.service.ServicioPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<MedicoDTO> medicoList = new ArrayList<>();

        for(MedicoDTO medico : medicoMapper.mapAsList(medicoRepository.findAll())){
            List<ServicioPrestadoDTO> serviciosPrestadosPorMedico = servicioPrestadoService.getByIdMedico(medico.getId());
            medico.setServicios(extractServicioMedicoDtos(serviciosPrestadosPorMedico));
            medicoList.add(medico);
        }
        return medicoList;
    }

    @Override
    public MedicoDTO getByNroDocumento(String nroDocumento) {
        return medicoMapper.mapToDto(medicoRepository.findByNroDocumento(nroDocumento));
    }

    @Override
    public MedicoDTO getByNombresApellidos(String nombres, String apellidos) {
        return medicoMapper.mapToDto(medicoRepository.findByNombresAndApellidos(nombres.toUpperCase(), apellidos.toUpperCase()));
    }

    @Override
    public MedicoDTO save(MedicoDTO medicoDTO) throws Exception{

        Medico medico = medicoMapper.mapToEntity(medicoDTO);
        medico.setFechaNacimiento(medicoDTO.getFechaNacimiento());
        medico.setNombres(medicoDTO.getNombres().toUpperCase());
        medico.setApellidos(medicoDTO.getApellidos().toUpperCase());
        saveServiciosMedico(medicoDTO, medico);
        // se mapea lo guardado en la bd a un dto para mostrar los datos correctos
        MedicoDTO response = medicoMapper.mapToDto(medico);

        List<ServicioPrestadoDTO> serviciosPrestadosPorMedico = servicioPrestadoService.getByIdMedico(medico.getId());
        if(!serviciosPrestadosPorMedico.isEmpty()){
            response.setServicios(extractServicioMedicoDtos(serviciosPrestadosPorMedico));
        }else{
            response.setServicios(medicoDTO.getServicios());
        }

        Medico entity = medicoRepository.save(medico);
        return response;
    }

    private List<ServicioMedicoDTO> extractServicioMedicoDtos(List<ServicioPrestadoDTO> serviciosPrestadosPorMedico) {
        List<ServicioMedicoDTO> servicioMedicoDTOS = new ArrayList<>();
        for(ServicioPrestadoDTO prestadoDto : serviciosPrestadosPorMedico){
            ServicioMedicoDTO dto = new ServicioMedicoDTO();
            dto.setCodHospital(hospitalService.getById(prestadoDto.getIdMedico()).getCodHospital());
            dto.setIdServicio(prestadoDto.getIdServicio());
            servicioMedicoDTOS.add(dto);
        }
        return servicioMedicoDTOS;
    }

    private void saveServiciosMedico(MedicoDTO medicoDTO, Medico entity) throws Exception {
        for(ServicioMedicoDTO dto : medicoDTO.getServicios()){
            try {
                Long idHospital = hospitalService.getByCodHospital(dto.getCodHospital()).getId();
                if (servicioPrestadoService.getByIdHospitalAndIdServicioAndIdMedico(idHospital, dto.getIdServicio(), entity.getId()) == null) {
                    ServicioPrestadoDTO servicioPrestadoDTO = new ServicioPrestadoDTO();
                    servicioPrestadoDTO.setIdHospital(idHospital);
                    servicioPrestadoDTO.setIdServicio(dto.getIdServicio());
                    servicioPrestadoDTO.setIdMedico(entity.getId());
                    servicioPrestadoService.save(servicioPrestadoDTO);
                }
            }catch (Exception e){
                throw new Exception("No se encontró el hospital o el servicio que se intenta registrar");
            }
        }
    }
}
