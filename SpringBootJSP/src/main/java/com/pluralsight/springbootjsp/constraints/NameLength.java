package com.pluralsight.springbootjsp.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameLengthValidator.class)
public @interface NameLength {

    String message() default "Invalid name length.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
