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
import java.util.Date;

@Entity
@Table(name = "patient")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Column(name = "patient_id",length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientId;
    @Column(name = "patient_name",length = 250,nullable = false)
    private String patientName;
    @Column(name = "patient_contact",columnDefinition = "json",nullable = false)
    @Type(type = "json")
    private ArrayList<String> patientContactNumber;
    @Column(name = "dob",nullable = false)
    private Date dob;
    @Column(name = "patient_history",columnDefinition = "json",nullable = false)
    @Type(type = "json")
    private ArrayList<String> illness;
}
