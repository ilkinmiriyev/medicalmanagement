package com.company.MedicalManagement.service;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    @Override
    public DoctorDTO findById(Long id) {
        return null;
    }

    @Override
    public List<DoctorDTO> findAll() {
        return null;
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
