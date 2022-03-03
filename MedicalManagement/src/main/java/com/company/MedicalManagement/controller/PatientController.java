package com.company.MedicalManagement.controller;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.dto.ResponseDTO;
import com.company.MedicalManagement.service.DoctorService;
import com.company.MedicalManagement.service.PatientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/patient", produces ="application/json")
@Api(value = "Patient Api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping
    public List<PatientDTO> getAllPatient(){
        System.out.println("all patient in controller "+patientService.findAll());
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public PatientDTO getPatientById(@PathVariable Long patientId){
        return patientService.findById(patientId);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> addPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO save = patientService.save(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO.of("Successfully added", save));
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<ResponseDTO> updatePatient(@RequestBody PatientDTO patientDTO, @PathVariable Long patientId){
        patientDTO.setId(patientId);
        PatientDTO update = patientService.save(patientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of("Successfully updated", update));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<ResponseDTO> deletePatient(@PathVariable Long patientId){
        try{
            patientService.deleteById(patientId);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of("Successfully deleted"));
    }

}
