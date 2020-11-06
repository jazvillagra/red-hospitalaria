package com.github.jazvillagra.redhospitalaria.web.controller;

import com.github.jazvillagra.redhospitalaria.constants.ApiPaths;
import com.github.jazvillagra.redhospitalaria.dto.HospitalDTO;
import com.github.jazvillagra.redhospitalaria.service.HospitalService;
import com.github.jazvillagra.redhospitalaria.web.response.ListResponseDTO;
import com.github.jazvillagra.redhospitalaria.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jazvillagra
 */
@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

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
}
