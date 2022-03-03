package com.company.MedicalManagement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
@ApiModel(value = "Patient")
public class Patient {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "birthdate")
    private Date patientBirthdate;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Doctor doctor;

    public Patient() {
    }

    public Patient(Long id, String fullName, Date birthdate, Doctor doctor) {
        this.id = id;
        this.fullName = fullName;
        this.patientBirthdate = birthdate;
        this.doctor = doctor;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(Date patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
