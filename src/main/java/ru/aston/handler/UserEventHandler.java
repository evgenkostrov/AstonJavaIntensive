package ru.aston.handler;


import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventType;


public interface UserEventHandler {
    UserEventType getEventType();
    void handle(UserEventDTO event);
}
