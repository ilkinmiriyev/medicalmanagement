package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.model.Patient;
import com.company.MedicalManagement.repository.PatientRepository;
import com.company.MedicalManagement.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @Override
    public PatientDTO findById(Long id) {
        Patient patient = patientRepository
                .findById(id)
                .get();
        return convertToPatientDTO(patient);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<PatientDTO> collect = patientRepository
                .findAll()
                .stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
        System.out.println(" all patient in controller "+collect);
        return collect;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient = convertDtoToEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return convertToPatientDTO(savedPatient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToPatientDTO(Patient patient){
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFullName(patient.getFullName());
        patientDTO.setBirthdate(patient.getPatientBirthdate());
        patientDTO.setDoctor(patient.getDoctor());
        return patientDTO;
    }
    private Patient convertDtoToEntity(PatientDTO patientDTO){
        Patient patient=new Patient();
        BeanUtils.copyProperties(patientDTO,patient);
        return patient;
    }
}
