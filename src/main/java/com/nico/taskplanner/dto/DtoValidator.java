package com.nico.taskplanner.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DtoValidator {

    @Autowired
    private Validator validator;

    public <T> void validateDto(T dto) {
        Set<ConstraintViolation<T>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : violations)
                sb.append(constraintViolation.getMessage());
            throw new ConstraintViolationException("Datos inválidos: " + sb.toString(), violations);
        }
    }


}
