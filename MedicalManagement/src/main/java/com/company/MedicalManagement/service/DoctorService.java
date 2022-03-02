package com.company.MedicalManagement.service;


import com.company.MedicalManagement.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {

    DoctorDTO findById(Long id);

    List<DoctorDTO> findAll();

    DoctorDTO save (DoctorDTO doctorDTO);

    void deleteById(Long id);

}
