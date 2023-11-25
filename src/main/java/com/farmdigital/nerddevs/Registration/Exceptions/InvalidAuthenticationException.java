package com.farmdigital.nerddevs.Registration.Exceptions;

public class InvalidAuthenticationException extends RuntimeException {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
