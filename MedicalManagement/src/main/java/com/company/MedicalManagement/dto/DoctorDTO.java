package com.company.MedicalManagement.dto;

import java.util.Date;

public class DoctorDTO {
    private Long id ;
    private String fullName;
    private Date birthdate;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String fullName, Date birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
