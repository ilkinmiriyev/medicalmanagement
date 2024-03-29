package com.company.MedicalManagement.service;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Optional<DoctorDTO> findById(Long id);

    List<DoctorDTO> findAll();

    DoctorDTO save(DoctorDTO doctorDTO);

    void deleteById(Long id) throws ResourceNotFoundException;
}
