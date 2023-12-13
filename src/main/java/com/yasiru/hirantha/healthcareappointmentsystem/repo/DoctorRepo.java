package com.yasiru.hirantha.healthcareappointmentsystem.repo;

import com.yasiru.hirantha.healthcareappointmentsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories
@EnableSwagger2
public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
