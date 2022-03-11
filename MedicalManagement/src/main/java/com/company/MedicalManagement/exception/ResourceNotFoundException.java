package com.company.MedicalManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.function.Supplier;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String message;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
