package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private Object data;
    private Object error;

    public GenericResponse(final Object data) {
        this.data = data;
    }

    public GenericResponse(String message, String errorCode) {
        this.error = new ErrorResponse(message, errorCode);
    }

    public GenericResponse(List<ObjectError> allErrors, String errorCode) {
        this.error = new ErrorResponse(allErrors, errorCode);
    }

    @Data
    class ErrorResponse {
        private String message;
        private String errorCode;

        private ErrorResponse(String message, String errorCode) {
            this.message = message;
            this.errorCode = errorCode;
        }

        private ErrorResponse(List<ObjectError> allErrors, String errorCode) {
            this.errorCode = errorCode;
            String temp = allErrors.stream().map(e -> {
                if (e instanceof FieldError) {
                    return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
                    // messageSource.getMessage(fieldError, Locale.getDefault())
                } else {
                    return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
                }
            }).collect(Collectors.joining(","));
            this.message = "[" + temp + "]";
        }

    }
}
