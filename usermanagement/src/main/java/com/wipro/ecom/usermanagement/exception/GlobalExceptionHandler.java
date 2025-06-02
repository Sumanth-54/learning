package com.wipro.ecom.usermanagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(UserNotFoundException ex, HttpServletRequest req) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 404, "Not Found", ex.getMessage(), req.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest req) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 500, "Internal Server Error", ex.getMessage(), req.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
