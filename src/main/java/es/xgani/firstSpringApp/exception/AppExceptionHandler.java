package es.xgani.firstSpringApp.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException erdae) {
        return new ResponseEntity<>(erdae.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

}
