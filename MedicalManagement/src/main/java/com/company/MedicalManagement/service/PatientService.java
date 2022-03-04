package com.company.MedicalManagement.service;


import com.company.MedicalManagement.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Optional<PatientDTO> findById(Long id);

    List<PatientDTO> findAll();

    PatientDTO save (PatientDTO patientDTO);

    void deleteById(Long id);

}
