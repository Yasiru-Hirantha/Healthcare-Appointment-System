package com.yasiru.hirantha.healthcareappointmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    private long doctorId;
    private String doctorName;
    private String specialization;
    private ArrayList doctorContactNumber;
    private  double channellingFee;
    private ArrayList conditionOrDisease;
    private int patientsPerDay;
}
