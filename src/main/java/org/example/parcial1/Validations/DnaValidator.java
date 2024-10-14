package org.example.parcial1.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {

        if (dna == null || dna.length == 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array no puede ser nulo o vacio.")
                    .addConstraintViolation();
            return false;
        }

        // Validar si el array es NxN (cuadrado)
        int size = dna.length;
        if (!Arrays.stream(dna).allMatch(row -> row.length() == size)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array debe ser NxN.")
                    .addConstraintViolation();
            return false;
        }

        // Validar que no contenga números
        if (Arrays.stream(dna).anyMatch(row -> row.matches(".*\\d+.*"))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array no debe contener numeros.")
                    .addConstraintViolation();
            return false;
        }

        // Validar que contenga solo A, T, G, C
        if (!Arrays.stream(dna).allMatch(row -> row.matches("[ATGC]+"))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Solo debe haber caracteres: 'A', 'T', 'G', 'C'.")
                    .addConstraintViolation();
            return false;
        }

        // Validar que no sea homogéneo (todo el array igual)
        char firstChar = dna[0].charAt(0);
        boolean isHomogeneous = Arrays.stream(dna)
                .allMatch(row -> row.chars().allMatch(ch -> ch == firstChar));
        if (isHomogeneous) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El array no puede ser homogeneo (todas las letras iguales).")
                    .addConstraintViolation();
            return false;
        }

        // Si pasa todas las validaciones, es válido
        return true;
    }
}
