package com.domain.devcinelocadora.exception;

import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import com.domain.devcinelocadora.dto.error.CustomError;
import com.domain.devcinelocadora.dto.error.FieldMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldMessage> errors = ex.getBindingResult().getFieldErrors().stream().map(
                fe -> new FieldMessage(fe.getField(), fe.getDefaultMessage())).toList();

        var customError = new CustomError(Instant.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Invalid data", request.getRequestURI(), errors);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError);
    }
}
