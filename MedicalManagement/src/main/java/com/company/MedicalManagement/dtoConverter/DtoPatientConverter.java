package com.company.MedicalManagement.dtoConverter;

import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.model.Patient;

public class DtoPatientConverter{

    public static Patient convertToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFullName(patientDTO.getFullName());
        patient.setId(patientDTO.getId());
        patient.setPatientBirthdate(patientDTO.getBirthdate());
//        patient.setDoctor(patientDTO.getDoctor());
        return patient;
    }
}
