package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to ensure that part inventory levels do not exceed above a maximum threshold.
 */
@Constraint(validatedBy = {PartMaxInvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaxPartInventory {
    String message() default "Inventory levels must remain Below the Maximum required limit.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
