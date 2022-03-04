package com.company.MedicalManagement.controller;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.dto.PatientDTO;
import com.company.MedicalManagement.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/doctor", produces = "application/json")
@Api(value = "Doctor Api")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ApiOperation(value = "Get Doctors")
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctor() {
        List<DoctorDTO> doctorDTOS = doctorService.findAll();
        if (doctorDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(doctorDTOS, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Get Doctor BY ID")
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("doctorId") Long doctorId) {

        Optional<DoctorDTO> optionalDoctorDTO = doctorService.findById(doctorId);
        if (optionalDoctorDTO.isPresent()) {
            return new ResponseEntity<>(optionalDoctorDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Patients of Doctor BY ID")
    @GetMapping("/{doctorId}/patient")
    public ResponseEntity<List<PatientDTO>> getPatientByDoctorId(@PathVariable("doctorId") Long doctorId) {
        Optional<DoctorDTO> optionalDoctorDTO = doctorService.findById(doctorId);
        if (optionalDoctorDTO.isPresent()) {
            return new ResponseEntity<>(optionalDoctorDTO.get().getPatientDTO(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Add Doctor")
    @PostMapping
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            DoctorDTO save = doctorService.save(doctorDTO);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update Doctor")
    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO, @PathVariable("doctorId") Long doctorId) {
        Optional<DoctorDTO> optionalDoctorDTO = doctorService.findById(doctorId);
        if (optionalDoctorDTO.isPresent()) {
            doctorDTO.setId(doctorId);
            return new ResponseEntity<>(doctorService.save(doctorDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Delete Doctor")
    @DeleteMapping("/{doctorId}")
    public ResponseEntity deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        try {
            doctorService.deleteById(doctorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
