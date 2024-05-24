package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator to ensure that the inventory level of a part is always above its minimum threshold.
 */
public class PartMinInvValidator implements ConstraintValidator<ValidMinPartInventory, Part> {
    @Autowired
    private ApplicationContext context;  // Autowires the Spring ApplicationContext to access application-wide resources.

    public static ApplicationContext myContext;  // A static reference to ApplicationContext, usable across non-bean static methods.

    @Override
    public void initialize(ValidMinPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);  // Invokes default initialization of the constraint provided by the framework.
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() > part.getMinimum();  // Evaluates if the part's current inventory is greater than its specified minimum value.
    }
}
