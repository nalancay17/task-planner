package com.nico.taskplanner;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ValidationsManager {

    public static Validator validator;


    public static void setValidator(Validator validator) {
        ValidationsManager.validator = validator;
    }

    public static <T> Set<ConstraintViolation<T>> validate(T object) {
        return validator.validate(object);
    }

    public static <T> void assertNoViolations(T object) {
        Set<ConstraintViolation<T>> violations = validate(object);
        assertTrue(violations.isEmpty(), "Se encontraron violaciones de constraint: " + violations);
    }

    public static <T> void assertConstraintViolationOnAttribute(T object, String attributeName, String message) {
        Set<ConstraintViolation<T>> violations = validate(object);
        for (ConstraintViolation<T> violation : violations) {
            if (violation.getPropertyPath().toString().equals(attributeName) && violation.getMessage().equals(message)) {
                return;
            }
        }
        fail("No se encontró violación de constraint en el atributo: " + attributeName + " con el mensaje: " + message);
    }
}
