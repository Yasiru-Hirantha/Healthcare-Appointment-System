package com.yasiru.hirantha.healthcareappointmentsystem.service.impl;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientUpdateDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.config.ModelMapperConfig;
import com.yasiru.hirantha.healthcareappointmentsystem.entity.Patient;
import com.yasiru.hirantha.healthcareappointmentsystem.repo.PatientRepo;
import com.yasiru.hirantha.healthcareappointmentsystem.service.PatientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveNewPatient(PatientDTO patientDTO) {
        Patient patient=modelMapper.map(patientDTO,Patient.class);
        patientRepo.save(patient);
        return "Successfully save the patient :"+patientDTO.getPatientId();
    }

    @Override
    public String updatePatient(PatientUpdateDTO patientUpdateDTO) {

       if(patientRepo.existsById(patientUpdateDTO.getPatientId())) {
           Patient patient=patientRepo.getReferenceById(patientUpdateDTO.getPatientId());
           patient.setPatientContactNumber(patientUpdateDTO.getPatientContactNumber());
           patient.setIllness(patientUpdateDTO.getIllness());
           patientRepo.save(patient);
           return "Successfully updated the patient :"+patientUpdateDTO.getPatientId();
       }else return "wrong patientId";
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList=patientRepo.findAll();
        if (patientList.size()>0) {
            List<PatientDTO> patientDTOList = modelMapper.map(patientList, new TypeToken<List<PatientDTO>>() {
            }.getType());
            return patientDTOList;
        }else throw new RuntimeException("Error");
    }

    @Override
    public String deletePatientById(long patientId) {
        if(patientRepo.existsById(patientId)){
            patientRepo.deleteById(patientId);
            return "Successfully deleted the patient :"+patientId;
        }else throw new RuntimeException("Wrong patient Id");
    }

    @Override
    public PatientDTO getPatientById(long patientId) {
        if(patientRepo.existsById(patientId)){
            Patient patient=patientRepo.getReferenceById(patientId);
            PatientDTO patientDTO=modelMapper.map(patient,PatientDTO.class);
            return patientDTO;
        } else  throw new RuntimeException("Wrong patient Id");
    }


}
