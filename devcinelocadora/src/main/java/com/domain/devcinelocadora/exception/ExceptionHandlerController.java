package com.domain.devcinelocadora.exception;

import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.EntityNotFoundException;
import com.domain.devcinelocadora.dto.error.CustomError;
import com.domain.devcinelocadora.dto.error.FieldMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({
            EntityNotFoundException.class,
            FilmeNotFoundException.class,
            ClienteNotFoundException.class
    })
    public ResponseEntity<CustomError> entityNotFoundException(RuntimeException ex, HttpServletRequest request) {
        CustomError error = new CustomError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<CustomError> illegalStateException(IllegalStateException ex, HttpServletRequest request) {
        CustomError error = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        CustomError error = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Violações de integridade de dados (como chave duplicada) foram detectadas.",
                request.getRequestURI(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldMessage> errors = ex.getBindingResult().getFieldErrors().stream().map(
                fe -> new FieldMessage(fe.getField(), fe.getDefaultMessage())).toList();

        var customError = new CustomError(Instant.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Invalid data", request.getRequestURI(), errors);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError);
    }
}
