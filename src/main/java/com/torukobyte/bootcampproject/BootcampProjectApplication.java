package com.torukobyte.bootcampproject;

import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class BootcampProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampProjectApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "VALIDATION EXCEPTION");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(ValidationException exception) {
        return new ErrorDataResult<>(exception.getMessage(), "VALIDATION EXCEPTION");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBusinessException(BusinessException exception) {
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(exception.getMessage(), "BUSINESS EXCEPTION");

        return errorDataResult;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(exception.getMessage(),
                                                                        "DATA INTEGRITY VIOLATION EXCEPTION");

        return errorDataResult;
    }
}
