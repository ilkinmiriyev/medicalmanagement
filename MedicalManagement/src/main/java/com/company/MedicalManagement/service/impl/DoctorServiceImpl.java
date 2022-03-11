package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dtoConverter.DtoDoctorConverter;
import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.exception.ResourceNotFoundException;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.repository.DoctorRepository;
import com.company.MedicalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<DoctorDTO> findById(Long id) {
        return doctorRepository
                .findById(id)
                .map(DoctorDTO::new);
    }

    @Override
    public List<DoctorDTO> findAll() {
        return doctorRepository
                .findAll()
                .stream()
                .map(DoctorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        Doctor doctor = new DtoDoctorConverter().convertToDoctor(doctorDTO);

        return new DoctorDTO(doctorRepository.save(doctor));
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID not found for deleteById"));
        doctorRepository.delete(doctor);
    }
}
