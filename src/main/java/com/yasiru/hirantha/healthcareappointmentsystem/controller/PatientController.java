package com.yasiru.hirantha.healthcareappointmentsystem.controller;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.service.PatientService;
import com.yasiru.hirantha.healthcareappointmentsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/save-patient")
    public ResponseEntity<StandardResponse> savePatient(@RequestBody  PatientDTO patientDTO){
        String data= patientService.saveNewPatient(patientDTO);
        return new ResponseEntity<StandardResponse> (
                new StandardResponse(201,"successful",data),
                HttpStatus.CREATED
        );

    }
    @PutMapping("/update-patient")
    public ResponseEntity<StandardResponse> updatePatient(@RequestBody PatientUpdateDTO patientUpdateDTO){
        String data=patientService.updatePatient(patientUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successful",data),
                HttpStatus.OK
        );
    }
    @GetMapping("/get-all-patient")
    public ResponseEntity<StandardResponse> getAllPatients(){
        List<PatientDTO> data =patientService.getAllPatients();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfull",data),
                HttpStatus.OK
        );
    }
    @DeleteMapping("delete-patient-by-id")
    public ResponseEntity<StandardResponse> deletePatientById(@RequestParam(value = "id") long patientId){
        String data=patientService.deletePatientById(patientId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successful",data),
                HttpStatus.OK
        );
    }
    @GetMapping("get-patient-by-id")
    public ResponseEntity<StandardResponse> getPatientDetailsById(@RequestParam(value = "id") long patientId){
        PatientDTO patientDTO=patientService.getPatientById(patientId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successful",patientDTO),
                HttpStatus.OK
        );
    }

}
