package it.davide.lascaux.challenge.cinemille.handler.exception;

import it.davide.lascaux.challenge.cinemille.model.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CineMilleExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<String>> handleException(Exception ex) {
        Result<String> result = new Result<>();
        result.error("GENERIC ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(result);
    }
}
