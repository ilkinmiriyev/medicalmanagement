package com.company.MedicalManagement.controller;

import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.dto.RequestPatient;
import com.company.MedicalManagement.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/patient", produces = "application/json")
@Api(value = "Patient Api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation(value = "Get Patient")
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatient() {
        List<PatientDTO> patientDTOS = patientService.findAll();
        if (patientDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(patientDTOS, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Get Patient BY ID")
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("patientId") Long patientId) {
        Optional<PatientDTO> optionalPatientDTO = patientService.findById(patientId);
        if (optionalPatientDTO.isPresent()) {
            return new ResponseEntity<>(optionalPatientDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Add Patient")
    @PostMapping
    public ResponseEntity addPatient(@RequestBody RequestPatient patient) {
        try {
            PatientDTO save = patientService.save(patient);
            return new ResponseEntity(save, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update Patient")
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody RequestPatient requestPatient,
                                                    @PathVariable("patientId") Long patientId) {
        Optional<PatientDTO> optionalPatientDTO = patientService.findById(patientId);
        if (optionalPatientDTO.isPresent()) {
            requestPatient.setId(patientId);
            return new ResponseEntity<>(patientService.save(requestPatient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Delete Patient")
    @DeleteMapping("/{patientId}")
    public ResponseEntity deletePatient(@PathVariable("patientId") Long patientId) {
        try {
            patientService.deleteById(patientId);
            System.out.println("Patient for delete :: " + patientId);
            return new ResponseEntity<>("Succesfully deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
