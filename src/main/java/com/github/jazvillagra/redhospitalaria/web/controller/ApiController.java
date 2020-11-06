package com.github.jazvillagra.redhospitalaria.web.controller;

import com.github.jazvillagra.redhospitalaria.constants.ApiPaths;
import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.dto.ServicioDTO;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import com.github.jazvillagra.redhospitalaria.service.ServicioService;
import com.github.jazvillagra.redhospitalaria.web.response.ListResponseDTO;
import com.github.jazvillagra.redhospitalaria.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
     * Servicio
     * @return
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
}
