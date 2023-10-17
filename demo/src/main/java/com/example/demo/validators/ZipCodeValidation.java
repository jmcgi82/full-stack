package com.example.demo.validators;

import com.example.demo.entities.Customer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ZipCodeValidation implements ConstraintValidator<ValidZipCode, String> {
    @Override
    public void initialize(ValidZipCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String zip, ConstraintValidatorContext constraintValidatorContext) {


        return zip != null && zip.matches("[0-9]+") && (zip.length() == 5);
    }
}
