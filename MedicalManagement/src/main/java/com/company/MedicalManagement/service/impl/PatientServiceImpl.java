package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.model.Patient;
import com.company.MedicalManagement.repository.PatientRepository;
import com.company.MedicalManagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper){
        this.modelMapper=modelMapper;
        this.patientRepository=patientRepository;
    }

    @Override
    public PatientDTO findById(Long id) {
        Patient patient = patientRepository
                .getById(id);
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<PatientDTO> collect = patientRepository
                .findAll()
                .stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

}
