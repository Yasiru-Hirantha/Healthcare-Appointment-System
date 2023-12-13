package com.yasiru.hirantha.healthcareappointmentsystem.service.impl;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.entity.Doctor;
import com.yasiru.hirantha.healthcareappointmentsystem.repo.DoctorRepo;
import com.yasiru.hirantha.healthcareappointmentsystem.service.DoctorService;
import com.yasiru.hirantha.healthcareappointmentsystem.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveNewDoctor(DoctorDTO doctorDTO) {
        Doctor doctor=modelMapper.map(doctorDTO,Doctor.class);
        doctorRepo.save(doctor);
        return "Successfully save the doctor :"+doctorDTO.getDoctorId();
    }
}
