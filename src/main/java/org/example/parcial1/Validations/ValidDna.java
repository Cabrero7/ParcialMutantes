package org.example.parcial1.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DnaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDna {

    // Mensaje de error predeterminado si la validación falla.
    String message() default "Secuencia de ADN inválida";

    // Grupos de validación, por defecto no se especifica ninguno.
    Class<?>[] groups() default {};

    // Carga útil de validación, por defecto no se especifica ninguna.
    Class<? extends Payload>[] payload() default {};

}
