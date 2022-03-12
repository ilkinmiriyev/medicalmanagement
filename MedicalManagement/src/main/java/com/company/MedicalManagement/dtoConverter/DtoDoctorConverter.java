package com.company.MedicalManagement.dtoConverter;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DtoDoctorConverter implements Function<DoctorDTO, Doctor> {

    @Override
    public Doctor apply(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setBirthdate(doctorDTO.getBirthdate());
        doctor.setFullName(doctorDTO.getFullName());
        doctor.setId(doctorDTO.getId());

        if (!(doctorDTO.getPatientDTO() == null || doctorDTO.getPatientDTO().isEmpty())) {
            List<Patient> list = doctorDTO.getPatientDTO()
                    .stream()
                    .map((x) -> new DtoPatientConverter().apply(x))
                    .collect(Collectors.toList());
            doctor.setPatient(list);
        }
        return doctor;
    }
}
