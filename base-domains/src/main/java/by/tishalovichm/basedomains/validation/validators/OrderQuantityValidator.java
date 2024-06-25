package by.tishalovichm.basedomains.validation.validators;

import by.tishalovichm.basedomains.validation.OrderQuantityConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderQuantityValidator
        implements ConstraintValidator<OrderQuantityConstraint, Integer> {

    @Override
    public boolean isValid(Integer quantity,
                           ConstraintValidatorContext constraintValidatorContext) {

        return quantity != null && quantity > 0;
    }

}
