package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validates that a Part's inventory does not exceed its maximum limit.
 */
public class PartMaxInvValidator implements ConstraintValidator<ValidMaxPartInventory, Part> {
    @Autowired
    private ApplicationContext context;  // Autowires the Spring ApplicationContext to access application-wide resources.

    public static  ApplicationContext myContext;  // A static reference to ApplicationContext, usable across non-bean static methods.

    @Override
    public void initialize(ValidMaxPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);  // Invokes default initialization of the constraint provided by the framework.
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() <= part.getMaximum();  // Ensures inventory does not exceed the maximum allowed
    }
}
