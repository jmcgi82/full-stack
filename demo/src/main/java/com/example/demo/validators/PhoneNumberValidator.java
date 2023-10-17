package com.example.demo.validators;

import com.example.demo.entities.Customer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Customer> {
    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext constraintValidatorContext) {
        String phone = customer.getPhone();

        return phone != null && phone.matches("[0-9]+") && (phone.length() > 8) && (phone.length() < 14);
    }
}
