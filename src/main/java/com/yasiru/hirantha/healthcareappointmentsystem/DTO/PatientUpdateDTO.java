package com.yasiru.hirantha.healthcareappointmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientUpdateDTO {
    private long patientId;
    private ArrayList patientContactNumber;
    private ArrayList illness;
}
