package com.niladri.product_service.validations;

import com.niladri.product_service.entity.COLORS;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ColorValidation implements ConstraintValidator<ColorSchemaValidation,String> {
    @Override
    public void initialize(ColorSchemaValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null || value.isEmpty())
            return false;
      try {
          COLORS color = COLORS.valueOf(value);
          return true;
      }catch (IllegalArgumentException e){
          return false;
      }
    }
}
