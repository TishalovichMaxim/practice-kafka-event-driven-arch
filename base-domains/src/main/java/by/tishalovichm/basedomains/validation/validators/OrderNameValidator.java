package by.tishalovichm.basedomains.validation.validators;

import by.tishalovichm.basedomains.validation.OrderNameConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderNameValidator implements ConstraintValidator<OrderNameConstraint, String> {

    @Override
    public boolean isValid(
            String s, ConstraintValidatorContext constraintValidatorContext) {

        return s != null
                && s.length() > 3
                && s.length() < 200;
    }

}
