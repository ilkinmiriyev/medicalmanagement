package com.company.MedicalManagement.dtoConverter;

import com.company.MedicalManagement.dto.RequestPatient;
import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestPatientConverter implements Function<RequestPatient, Patient> {

    public RequestPatientConverter() {
    }

    @Override
    public Patient apply(RequestPatient requestPatient) {
        Patient patient = new Patient();
        patient.setId(requestPatient.getId());
        patient.setPatientBirthdate(requestPatient.getBirthdate());
        patient.setFullName(requestPatient.getFullname());
        Doctor doctor = new Doctor();
        doctor.setId(requestPatient.getDoctorId());
        patient.setDoctor(doctor);

        return patient;
    }
}
