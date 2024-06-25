package by.tishalovichm.basedomains.validation;

import by.tishalovichm.basedomains.validation.validators.OrderQuantityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OrderQuantityValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderQuantityConstraint {

    String message() default "Invalid order quantity";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
