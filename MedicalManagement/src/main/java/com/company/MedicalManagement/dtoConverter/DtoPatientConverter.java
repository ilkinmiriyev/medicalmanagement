package com.company.MedicalManagement.dtoConverter;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;

import java.util.function.Function;

public class DtoPatientConverter implements Function<PatientDTO, Patient> {

    @Override
    public Patient apply(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFullName(patientDTO.getFullName());
        patient.setId(patientDTO.getId());
        patient.setPatientBirthdate(patientDTO.getBirthdate());
//        patient.setDoctor(patientDTO.getDoctor());
        return patient;
    }
}
