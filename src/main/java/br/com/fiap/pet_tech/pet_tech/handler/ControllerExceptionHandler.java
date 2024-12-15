package br.com.fiap.pet_tech.pet_tech.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.pet_tech.pet_tech.errors.StandardErrorResponse;
import br.com.fiap.pet_tech.pet_tech.exceptions.ControllerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private StandardErrorResponse error = new StandardErrorResponse();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> entityNotFound(ControllerNotFoundException e, HttpServletRequest request) {

            HttpStatus status = HttpStatus.NOT_FOUND;
            error.setTimestamp(Instant.now());
            error.setStatus(status.value());
            error.setError("Entity not found");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());

            return ResponseEntity.status(status).body(error);
        }


}
