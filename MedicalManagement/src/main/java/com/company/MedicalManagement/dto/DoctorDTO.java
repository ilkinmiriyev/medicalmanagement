package com.company.MedicalManagement.dto;

import com.company.MedicalManagement.model.Doctor;
import com.company.MedicalManagement.model.Patient;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorDTO {
    private Long id;
    private String fullName;
    private Date birthdate;
    private List<PatientDTO> patientDTOS;

//    private final ModelMapper modelMapper = new ModelMapper();

    public DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.fullName = doctor.getFullName();
        this.birthdate = doctor.getBirthdate();

       /* List<PatientDTO> patientDTOS=new ArrayList<>();

        for (Patient patient : doctor.getPatient()) {
            patientDTOS.add(new PatientDTO(patient));
        }
        this.patientDTOS=patientDTOS;*/


        if (!(doctor.getPatient()==null || doctor.getPatient().isEmpty())) {
            this.patientDTOS = doctor.getPatient()
                    .stream()
                    .map(patient -> new PatientDTO(patient))
                    .collect(Collectors.toList());
        }
    }

    public DoctorDTO(Long id, String fullName, Date birthdate, List<PatientDTO> patientDTOS) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.patientDTOS = patientDTOS;
    }

    public DoctorDTO() {
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

    public List<PatientDTO> getPatientDTO() {
        return patientDTOS;
    }

    public void setPatientDTO(List<PatientDTO> patientDTOS) {
        this.patientDTOS = patientDTOS;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                ", patientDTOS=" + patientDTOS +
                '}';
    }
}
