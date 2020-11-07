package com.github.jazvillagra.redhospitalaria.web.controller;

import com.github.jazvillagra.redhospitalaria.constants.ApiPaths;
import com.github.jazvillagra.redhospitalaria.dto.CamasDTO;
import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.dto.MedicoDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.entities.Camas;
import com.github.jazvillagra.redhospitalaria.service.*;
import com.github.jazvillagra.redhospitalaria.web.response.ListResponseDTO;
import com.github.jazvillagra.redhospitalaria.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jazvillagra
 */
@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ServicioPrestadoService servicioPrestadoService;

    @Autowired
    private CamasService camasService;

    /**
     * Hospital Services
     */
    @PostMapping(ApiPaths.HOSPITAL_SAVE)
    public ResponseEntity<ObjectResponseDTO<HospitalDTO>> saveHospital(@RequestBody HospitalDTO hospital) {
        return ResponseEntity.ok(ObjectResponseDTO.success(hospitalService.save(hospital)));
    }

    @GetMapping(ApiPaths.BASE_HOSPITAL)
    public ResponseEntity<ListResponseDTO<HospitalDTO>> getAllHospitales() {
        return ResponseEntity.ok(ListResponseDTO.success(hospitalService.getAllHospitales()));
    }

    @GetMapping(ApiPaths.HOSPITAL_BY_COD_HOSPITAL)
    public ResponseEntity<ObjectResponseDTO<HospitalDTO>> getHospitalByCodHospital(@PathVariable String codHospital){
        return ResponseEntity.ok(ObjectResponseDTO.success(hospitalService.getByCodHospital(codHospital)));
    }
    /**
     * Servicio Services
     */
    @GetMapping(ApiPaths.BASE_SERVICIO)
    public ResponseEntity<ListResponseDTO<ServicioDTO>> getAllServicios(){
        return ResponseEntity.ok(ListResponseDTO.success(servicioService.getAllServicios()));
    }

    @PostMapping(ApiPaths.SERVICIO_SAVE)
    public ResponseEntity<ObjectResponseDTO<ServicioDTO>> saveService(@RequestBody ServicioDTO servicioDTO){
        return ResponseEntity.ok(ObjectResponseDTO.success(servicioService.save(servicioDTO)));
    }

    @GetMapping(ApiPaths.SERVICIO_BY_COD_SERVICIO)
    public ResponseEntity<ObjectResponseDTO<ServicioDTO>> getServicioByCodServicio(@PathVariable String codServicio) {
        return ResponseEntity.ok(ObjectResponseDTO.success(servicioService.getByCodServicio(codServicio)));
    }
    // TODO probar si esto funciona
    /**
     * Medico Services
     */
    @GetMapping(ApiPaths.BASE_MEDICO)
    public ResponseEntity<ListResponseDTO<MedicoDTO>> getAllMedicos(){
        return ResponseEntity.ok(ListResponseDTO.success(medicoService.getAllMedicos()));
    }

    @PostMapping(ApiPaths.MEDICO_SAVE)
    public ResponseEntity<ObjectResponseDTO<MedicoDTO>> saveMedico(@RequestBody MedicoDTO medicoDTO) throws Exception{
        return ResponseEntity.ok(ObjectResponseDTO.success(medicoService.save(medicoDTO)));
    }

    @GetMapping(ApiPaths.MEDICO_BY_NOMBRE_APELLIDO)
    public ResponseEntity<ObjectResponseDTO<MedicoDTO>> getMedicoByNombreApellido(@RequestParam String nombres,
                                                                                  @RequestParam String apellidos) {
        return ResponseEntity.ok(ObjectResponseDTO.success(medicoService.getByNombresApellidos(nombres, apellidos)));
    }
    /**
     * Camas services
     */
    @PostMapping(ApiPaths.REGISTRAR_SERVICIO_HOSPITAL)
    public ResponseEntity<ObjectResponseDTO<CamasDTO>> registrarServicioHospital(@RequestBody CamasDTO camas) {
        return ResponseEntity.ok(ObjectResponseDTO.success(camasService.save(camas)));
    }
}
