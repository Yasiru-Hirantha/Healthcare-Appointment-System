package com.yasiru.hirantha.healthcareappointmentsystem.controller;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.service.DoctorService;
import com.yasiru.hirantha.healthcareappointmentsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update-doctor")
    public ResponseEntity<StandardResponse> updateDoctor(@RequestBody DoctorUpdateDTO doctorUpdateDTO){
        String data=doctorService.updateDoctor(doctorUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successful",data),
                HttpStatus.OK
        );
    }
    @GetMapping("/get-all-doctor")
    public ResponseEntity<StandardResponse> getAllDoctors(){
        List<DoctorDTO> data =doctorService.getAllDoctors();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfull",data),
                HttpStatus.OK
        );
    }
    @DeleteMapping("delete-doctor-by-id")
    public ResponseEntity<StandardResponse> deleteDoctorById(@RequestParam(value = "id") long doctorId){
        String data=doctorService.deleteDoctorById(doctorId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successful",data),
                HttpStatus.OK
        );
    }
}
