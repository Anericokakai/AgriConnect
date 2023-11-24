package com.farmdigital.nerddevs.Exceptions.ExceptionController;

import com.farmdigital.nerddevs.Exceptions.InvalidAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class VerificationControllerAdvice {

    private  final Map<String ,String> errorMap= new HashMap<>();
    @ExceptionHandler(InvalidAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String ,String > unAuthorizedAccess(InvalidAuthenticationException ex){
        errorMap.put("errorMessage",ex.getMessage());
        errorMap.put("errorType","UNAUTHORIZED_REQUEST");
        return  errorMap;

    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public  Map<String ,String > handleNOTokenProvided(MissingServletRequestParameterException ex){

        errorMap.put("errorMessage",ex.getMessage());
        errorMap.put("errorType","FORBIDDEN REQUEST");
        return  errorMap;

    }

    @ExceptionHandler(MailSendException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  Map<String ,String > handleErrorOnEmailSend(MailSendException ex){
        errorMap.put("errorMessage",ex.getMessage());
        errorMap.put("errorType","INTERNAL_SERVER_ERROR");
        errorMap.put("errorDesc","there was a problem while sending an email to the user");
        return errorMap;


    }
}
