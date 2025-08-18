package ru.aston.exception;

public class InvalidUserException extends UserServiceException {
    public InvalidUserException(String message) {
        super(message);
    }
}