package com.company.MedicalManagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doctor")
@ApiModel(value = "Doctor")
public class Doctor {
    @Id
    @Column(name = "id", nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;

    @Column(name="fullname", nullable = false)
    private String fullName;

    @Column(name="birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Patient> patient;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                ", patient=" + patient +
                '}';
    }
}
