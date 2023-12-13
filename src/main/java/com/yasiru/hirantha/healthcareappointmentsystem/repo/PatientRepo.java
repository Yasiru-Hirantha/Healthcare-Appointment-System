package com.yasiru.hirantha.healthcareappointmentsystem.repo;

import com.yasiru.hirantha.healthcareappointmentsystem.DTO.PatientDTO;
import com.yasiru.hirantha.healthcareappointmentsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories
@EnableSwagger2
public interface PatientRepo extends JpaRepository<Patient,Long> {
}
