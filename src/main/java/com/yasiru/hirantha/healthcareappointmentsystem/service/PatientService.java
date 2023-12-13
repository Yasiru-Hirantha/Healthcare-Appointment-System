package com.yasiru.hirantha.healthcareappointmentsystem.service;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientUpdateDTO;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface PatientService {
    String saveNewPatient(PatientDTO patientDTO);

    String updatePatient(PatientUpdateDTO patientUpdateDTO);

    List<PatientDTO> getAllPatients();

    String deletePatientById(long patientId);

    PatientDTO getPatientById(long patientId);
}
