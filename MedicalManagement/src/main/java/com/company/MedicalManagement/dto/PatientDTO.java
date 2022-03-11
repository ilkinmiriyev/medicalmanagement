package com.company.MedicalManagement.dto;

import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;

import java.util.Date;

public class PatientDTO {
    private Long id;
    private String fullName;
    private Date birthdate;
//    private Doctor doctor;

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.fullName = patient.getFullName();
        this.birthdate = patient.getPatientBirthdate();
//        this.doctor=patient.getDoctor();
    }

    public PatientDTO(Long id, String fullName, Date birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
//        this.doctor=doctor;
    }

    public PatientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }

//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
}
