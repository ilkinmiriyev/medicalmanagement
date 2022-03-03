package com.company.MedicalManagement.service;


import com.company.MedicalManagement.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO findById(Long id);

    List<PatientDTO> findAll();

    PatientDTO save (PatientDTO patientDTO);

    void deleteById(Long id);

}
