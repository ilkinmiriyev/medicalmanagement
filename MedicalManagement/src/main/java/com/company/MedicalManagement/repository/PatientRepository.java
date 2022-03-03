package com.company.MedicalManagement.repository;

import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
