package by.tishalovichm.basedomains.validation.validators;

import by.tishalovichm.basedomains.validation.OrderPriceConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderPriceValidator
        implements ConstraintValidator<OrderPriceConstraint, Double> {

    @Override
    public boolean isValid(Double price,
                           ConstraintValidatorContext constraintValidatorContext) {

        return price != null && price > 0;
    }

}
