package by.tishalovichm.basedomains.validation;

import by.tishalovichm.basedomains.validation.validators.OrderPriceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OrderPriceValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderPriceConstraint {

    String message() default "Invalid order price";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
