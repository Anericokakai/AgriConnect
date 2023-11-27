package com.farmdigital.nerddevs.Profile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerForProfile {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleErrorWithJson(HttpMessageNotReadableException ex){

        ProblemDetail error= ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
        error.setProperty("error<Mesage",ex.getHttpInputMessage());
        return  error;

    }
}
