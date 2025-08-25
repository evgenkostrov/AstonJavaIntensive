package ru.aston.handler;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventType;
import ru.aston.service.EmailService;

@Service
@AllArgsConstructor
public class DeleteUserHandler implements UserEventHandler{
    private final EmailService emailService;

    @Override
    public UserEventType getEventType() {
        return UserEventType.DELETE_USER;
    }

    @Override
    public void handle(UserEventDTO event) {
        emailService.sendDeletedAccountEmail(event.getEmail());
    }
}
