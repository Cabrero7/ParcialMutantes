package org.example.parcial1.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

// Clase que implementa la interfaz ConstraintValidator para validar la anotación ValidDna.
public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    // Constante que define los caracteres válidos para el ADN.
    private static final String VALID_CHARACTERS = "AGTC";

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {

        // 1. Verificar si el array es null
        if (dna == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array no puede ser null").addConstraintViolation();
            return false;
        }

        // 2. Verificar si el array está vacío
        if (dna.length == 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array no puede estar vacío").addConstraintViolation();
            return false;
        }

        int n = dna.length;

        // 3. Verificar si el array es NxM en vez de NxN
        for (String row : dna) {
            if (row == null) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("El array no puede contener filas null").addConstraintViolation();
                return false;
            }

            if (row.length() != n) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("El array debe ser NxN, pero se encontró una fila de tamaño incorrecto").addConstraintViolation();
                return false;
            }
        }

        // 4. Verificar si contiene caracteres inválidos (números o letras no válidas)
        for (String row : dna) {
            for (char c : row.toCharArray()) {
                if (!VALID_CHARACTERS.contains(Character.toString(c))) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("El array contiene caracteres inválidos. Solo se permiten: " + VALID_CHARACTERS).addConstraintViolation();
                    return false;
                }
            }
        }

        // Si pasa todas las validaciones, es válido
        return true;
    }
}
