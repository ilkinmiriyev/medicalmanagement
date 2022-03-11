package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.dtoConverter.DtoPatientConverter;
import com.company.MedicalManagement.exception.ResourceNotFoundException;
import com.company.MedicalManagement.model.Patient;
import com.company.MedicalManagement.repository.PatientRepository;
import com.company.MedicalManagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<PatientDTO> findById(Long id) {
        return patientRepository.findById(id)
                .map(patient -> new PatientDTO(patient));
    }

    @Override
    public List<PatientDTO> findAll() {
        List<PatientDTO> collect = patientRepository
                .findAll()
                .stream()
                .map(patient -> new PatientDTO(patient))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient = new DtoPatientConverter().convertToPatient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return new PatientDTO(savedPatient);
    }

    @Override
    public void deleteById(Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this :: "+id));
        patientRepository.delete(patient);
    }

}
