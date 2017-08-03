package com.company.common.annotations.validate;

import com.company.common.dto.web.ClientDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        boolean isValid;
        try {
            ClientDto user = (ClientDto) obj;
            isValid = user.getPassword().equals(user.getMatchingPassword());
        }catch (Exception e){
            isValid = false;
        }
        return isValid;
    }

}