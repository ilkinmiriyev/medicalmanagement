package com.company.MedicalManagement.controller;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.dto.ResponseDTO;
import com.company.MedicalManagement.service.DoctorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/doctor", produces ="application/json")
@Api(value = "Doctor Api")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctor(){
        return doctorService.findAll();
    }

    @GetMapping("/{doctorId}")
    public DoctorDTO getDoctorById(@PathVariable Long doctorId){
        return doctorService.findById(doctorId);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> addDoctor(@RequestBody DoctorDTO doctorDTO){
        DoctorDTO save = doctorService.save(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO.of("Successfully added", save));
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<ResponseDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO, @PathVariable Long doctorId){
        doctorDTO.setId(doctorId);
        DoctorDTO update = doctorService.save(doctorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of("Successfully updated", update));
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<ResponseDTO> deleteDoctor(@PathVariable Long doctorId){
        try{
            doctorService.deleteById(doctorId);
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of("Successfully deleted"));
    }

}
