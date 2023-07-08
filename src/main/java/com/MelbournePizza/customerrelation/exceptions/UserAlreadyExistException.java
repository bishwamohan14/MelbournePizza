package com.MelbournePizza.customerrelation.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String number) {
        super("User with number " + number + " already exists");
    }
}
