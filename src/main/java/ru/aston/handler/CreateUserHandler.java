package ru.aston.handler;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventHandler;
import ru.aston.handler.UserEventType;
import ru.aston.service.EmailService;

@Service
public class CreateUserHandler implements UserEventHandler {
    private final EmailService emailService;

    public CreateUserHandler(EmailService mailService) {
        this.emailService = mailService;
    }

    @Override
    public UserEventType getEventType() {
        return UserEventType.CREATE_USER;
    }

    @Override
    public void handle(UserEventDTO event) {
        emailService.sendCreatedAccountEmail(event.getEmail());
    }
}
