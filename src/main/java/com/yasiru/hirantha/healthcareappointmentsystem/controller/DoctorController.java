package com.yasiru.hirantha.healthcareappointmentsystem.controller;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.service.DoctorService;
import com.yasiru.hirantha.healthcareappointmentsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/save-doctor")
    public ResponseEntity<StandardResponse> saveDoctor(@RequestBody DoctorDTO doctorDTO){
        String data=doctorService.saveNewDoctor(doctorDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"successful",data),
                HttpStatus.OK
        );

    }
}
