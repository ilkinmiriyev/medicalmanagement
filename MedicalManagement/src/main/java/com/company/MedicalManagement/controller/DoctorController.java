package com.company.MedicalManagement.controller;

import com.company.MedicalManagement.dto.DoctorDTO;
import com.company.MedicalManagement.service.DoctorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@Api(value = "Doctor Api")
public class DoctorController {

    @Autowired
    DoctorService doctorServiceInter;

    @GetMapping("doctors")
    public List<DoctorDTO> getAllDoctor(){
        return null;
    }


}
