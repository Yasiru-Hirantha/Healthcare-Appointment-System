package com.yasiru.hirantha.healthcareappointmentsystem.service.impl;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.DoctorUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.entity.Doctor;
import com.yasiru.hirantha.healthcareappointmentsystem.entity.Patient;
import com.yasiru.hirantha.healthcareappointmentsystem.repo.DoctorRepo;
import com.yasiru.hirantha.healthcareappointmentsystem.service.DoctorService;
import com.yasiru.hirantha.healthcareappointmentsystem.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String updateDoctor(DoctorUpdateDTO doctorUpdateDTO) {
        if(doctorRepo.existsById(doctorUpdateDTO.getDoctorId())) {
            Doctor doctor=doctorRepo.getReferenceById(doctorUpdateDTO.getDoctorId());
            doctor.setDoctorContactNumber(doctorUpdateDTO.getDoctorContactNumber());
            doctor.setChannellingFee(doctorUpdateDTO.getChannellingFee());
            doctor.setPatientsPerDay(doctorUpdateDTO.getPatientsPerDay());
            doctorRepo.save(doctor);
            return "Successfully updated the doctor :"+doctorUpdateDTO.getDoctorId();
        }else return "wrong doctorId";
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctorList=doctorRepo.findAll();
        if (doctorList.size()>0) {
            List<DoctorDTO> doctorDTOList = modelMapper.map(doctorList, new TypeToken<List<DoctorDTO>>() {
            }.getType());
            return doctorDTOList;
        }else throw new RuntimeException("Error");
    }

    @Override
    public String deleteDoctorById(long doctorId) {
        if(doctorRepo.existsById(doctorId)){
            doctorRepo.deleteById(doctorId);
            return "Successfully deleted the doctor :"+doctorId;
        }else throw new RuntimeException("Wrong doctor Id");
    }
}
