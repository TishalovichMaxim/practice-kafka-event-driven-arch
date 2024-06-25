package by.tishalovichm.basedomains.validation;

import by.tishalovichm.basedomains.validation.validators.OrderNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OrderNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderNameConstraint {

    String message() default "Invalid order name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
