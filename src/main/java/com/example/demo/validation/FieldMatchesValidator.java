package com.example.demo.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchesValidator implements ConstraintValidator<FieldsMatches, Object> {

    private String firstField;
    private String secondField;
    private String message;

    @Override
    public void initialize(FieldsMatches constraintAnnotation) {
        firstField = constraintAnnotation.field();
        secondField = constraintAnnotation.fieldMatch();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        boolean valid = true;

        try {
            final Object firstObj = BeanUtils.getProperty(o, firstField);
            final Object secondObj = BeanUtils.getProperty(o, secondField);
            valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}

        if (!valid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstField)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
