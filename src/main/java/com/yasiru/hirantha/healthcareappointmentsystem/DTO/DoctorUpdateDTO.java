package com.yasiru.hirantha.healthcareappointmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorUpdateDTO {
    private long doctorId;
    private ArrayList doctorContactNumber;
    private  double channellingFee;
    private int patientsPerDay;
}
