package com.example.demo.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ensure phone number is numerical and between 9 and 14 digits
 */
@Constraint(validatedBy = {ZipCodeValidation.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidZipCode {
    String message() default "Invalid Zip Code!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
