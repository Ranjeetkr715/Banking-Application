package com.banking.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle Specific exception --> AccountException.class
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception, WebRequest webRequest){
        ErrorDetails errorDetails= new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    //Handle Genric exception --> Genric.class
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenricException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails= new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
