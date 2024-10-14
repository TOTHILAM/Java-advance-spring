package com.vti.springframework.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private String getMessage(String key, Object... args) {
        var locale = LocaleContextHolder.getLocale();
        return getMessageSource().getMessage(key, args, locale);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatusCode status, WebRequest request
    ) {
       var message = getMessage("MethodArgumentNotValidException.message");
       var errors = new LinkedHashMap<String, String>();
       for (var error : exception.getFieldErrors()) {
           var key = error.getField();
           var value = error.getDefaultMessage();
           errors.put(key, value);
       }
       var response = new ErrorResponse(message, errors);
       return  new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handerConstraninViolation (
            ConstraintViolationException exception
    ) {
        var message = getMessage("MethodArgumentNotValidException.message");
        var errors = new LinkedHashMap<String, String>();
        for (var constrain : exception.getConstraintViolations()) {
            var key = constrain.getPropertyPath().toString();
            var value = constrain.getMessage();
            errors.put(key, value);
        }
        var reponse = new ErrorResponse(message, errors);
        return new ResponseEntity<>(reponse, HttpStatus.BAD_REQUEST);
    }
}
