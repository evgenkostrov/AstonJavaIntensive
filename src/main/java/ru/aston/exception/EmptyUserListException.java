package ru.aston.exception;

public class EmptyUserListException extends UserServiceException {
    public EmptyUserListException() {
        super("В системе пока нет пользователей");
    }
}