package com.company.MedicalManagement.model;

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
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty("FullName")
    @Column(name = "fullname", nullable = false)
    private String fullName;

    @ApiModelProperty("BirthDate")
    @Column(name = "birthdate")
    private Date birthdate;

    @ApiModelProperty("Patients")
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Patient> patient;

    @Column(name = "date_created")
    private Date dateCreated;

    public Doctor() {
    }

    public Doctor(Long id, String fullName, Date birthdate, List<Patient> patient, Date dateCreated) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.patient = patient;
        this.dateCreated = dateCreated;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
