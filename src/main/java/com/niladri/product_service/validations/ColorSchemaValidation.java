package com.niladri.product_service.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ColorValidation.class) // Link to your validator class
@Documented
public @interface ColorSchemaValidation {
    String message() default "Invalid value for this field."; // Default error message
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
