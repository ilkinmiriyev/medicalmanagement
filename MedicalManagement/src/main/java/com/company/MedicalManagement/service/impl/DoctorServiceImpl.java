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
                .findById(id).get();
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> findAll() {
        return doctorRepository
                .findAll()
                .stream()
                .map(doctor-> new DoctorDTO(doctor))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

}
