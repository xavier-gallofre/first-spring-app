package es.xgani.firstSpringApp.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private final Date timestamp;
    private String message;
    private List<ApiSubError> subErrors;

    private ApiError() {
        this.timestamp = new Date();
    }

    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
    }

    private void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    private void addValidationError(String object, String field) {
        addSubError(new ApiValidationError(object, field));
    }

    public void addFieldErrors(List<FieldError> errors) {
        errors.forEach(this::addFieldErrors);
    }

    private void addFieldErrors(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    public void addGlobalErrors(List<ObjectError> errors) {
        errors.forEach(this::addGlobalErrors);
    }

    public void addGlobalErrors(ObjectError errors) {
        this.addValidationError(
                errors.getObjectName(),
                errors.getDefaultMessage()
        );
    }
}
