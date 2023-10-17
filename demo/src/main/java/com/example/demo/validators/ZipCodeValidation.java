package com.example.demo.validators;

import com.example.demo.entities.Customer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ZipCodeValidation implements ConstraintValidator<ValidZipCode, Customer> {
    @Override
    public void initialize(ValidZipCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext constraintValidatorContext) {
        String zip = customer.getPhone();

        return zip != null && zip.matches("[0-9]+") && (zip.length() == 5);
    }
}
