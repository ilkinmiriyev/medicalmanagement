package com.company.MedicalManagement.service.impl;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.repository.DoctorRepository;
import com.company.MedicalManagement.service.DoctorService;
import org.springframework.beans.BeanUtils;
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
        Doctor doctor = doctorRepository
                .findById(id)
                .get();
        return convertToDoctorDTO(doctor);
    }

    @Override
    public List<DoctorDTO> findAll() {
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
        DoctorDTO doctorDTO=new DoctorDTO();
        BeanUtils.copyProperties(doctor, doctorDTO);
        return doctorDTO;
    }
    private Doctor convertDtoToEntity(DoctorDTO doctorDTO){
        Doctor doctor=new Doctor();
        BeanUtils.copyProperties(doctorDTO,doctor);
        return doctor;
    }
}
