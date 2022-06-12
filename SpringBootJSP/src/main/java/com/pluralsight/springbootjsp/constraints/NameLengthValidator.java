package com.pluralsight.springbootjsp.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameLengthValidator implements ConstraintValidator<NameLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() > 5;
    }
}
