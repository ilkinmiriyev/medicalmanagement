package com.company.MedicalManagement.dto;

import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;

import java.util.Date;

public class PatientDTO {
    private Long id;
    private String fullName;
    private Date birthdate;
    private String doctorName;

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.fullName = patient.getFullName();
        this.birthdate = patient.getPatientBirthdate();
        this.doctorName = patient.getDoctor().getFullName();
    }

    public PatientDTO(Long id, String fullName, Date birthdate, Doctor doctor) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
