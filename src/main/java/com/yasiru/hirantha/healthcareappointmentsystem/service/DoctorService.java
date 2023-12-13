package com.yasiru.hirantha.healthcareappointmentsystem.service;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorUpdateDTO;

import java.util.List;

public interface DoctorService {
    String saveNewDoctor(DoctorDTO doctorDTO);

    String updateDoctor(DoctorUpdateDTO doctorUpdateDTO);

    List<DoctorDTO> getAllDoctors();

    String deleteDoctorById(long doctorId);
}
