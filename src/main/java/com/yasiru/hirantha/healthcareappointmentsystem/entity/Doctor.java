package com.yasiru.hirantha.healthcareappointmentsystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "doctor")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    @Column(name = "doctor_id",length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctorId;
    @Column(name = "doctor_name",length = 250,nullable = false)
    private String doctorName;
    @Column(name = "specialization",nullable = false)
    private String specialization;
    @Column(name = "doctor_contact",columnDefinition = "json",nullable = false)
    @Type(type = "json")
    private ArrayList<String> doctorContactNumber;
    @Column(name = "fee",nullable = false)
    private  double channellingFee;
    @Column(name = "condition_or_disease",columnDefinition = "json",nullable = false)
    @Type(type = "json")
    private ArrayList<String> conditionOrDisease;
    @Column(name = "patients_per_day",nullable = false)
    private int patientsPerDay;




}
