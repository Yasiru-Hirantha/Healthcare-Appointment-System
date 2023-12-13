package com.yasiru.hirantha.healthcareappointmentsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private long patientId;
    private String patientName;
    private ArrayList patientContactNumber;
    private Date dob;
    private ArrayList illness;

}
