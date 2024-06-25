package by.tishalovichm.orderservice.exception;

public record ValidationFieldErrorInfo(
        String field,
        String message
) {
}

