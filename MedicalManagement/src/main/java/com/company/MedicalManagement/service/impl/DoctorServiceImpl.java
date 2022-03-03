package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.repository.DoctorRepository;
import com.company.MedicalManagement.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private ModelMapper modelMapper;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper){
        this.modelMapper=modelMapper;
        this.doctorRepository=doctorRepository;
    }

    @Override
    public DoctorDTO findById(Long id) {
        Doctor doctor = doctorRepository
                .findById(id)
                .get();
        return convertToDoctorDTO(doctor);
    }

    @Override
    public List<DoctorDTO> findAll() {
        System.out.println("Doctor Service IMPL "+doctorRepository.findAll().get(1).getPatient());
        return doctorRepository
                .findAll()
                .stream()
                .map(this::convertToDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        Doctor doctor = convertDtoToEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDoctorDTO(savedDoctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }


    private DoctorDTO convertToDoctorDTO(Doctor doctor){
        return modelMapper.map(doctor, DoctorDTO.class);
    }
    private Doctor convertDtoToEntity(DoctorDTO doctorDTO){
        return modelMapper.map(doctorDTO, Doctor.class);
    }
}
