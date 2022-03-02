package com.company.MedicalManagement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

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

    public Doctor(Long id, String fullName, Date birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public Doctor() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
