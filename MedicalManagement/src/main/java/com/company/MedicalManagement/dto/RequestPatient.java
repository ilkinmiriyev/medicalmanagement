package com.company.MedicalManagement.dto;

import java.util.Date;

public class RequestPatient {

    private Long id;
    private String fullname;
    private Date birthdate;
    private Long doctorId;

    public RequestPatient(Long id, String fullname, Date birthdate, Long doctorId) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
