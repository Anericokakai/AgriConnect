package com.farmdigital.nerddevs.Registration.Exceptions;

public class UserAlreadyExistException  extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
