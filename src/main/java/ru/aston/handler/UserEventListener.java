package ru.aston.handler;


import lombok.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventHandler;
import ru.aston.handler.UserEventType;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserEventListener {

    private final Map<UserEventType, UserEventHandler> handlers;

    @KafkaListener(topics = "${app.kafka.topics.user-events}", groupId = "notification-service")
    public void handleUserEvent(final UserEventDTO userEventDTO) {
        final UserEventType eventType = userEventDTO.getEventType();
        final String email = userEventDTO.getEmail();


        if (eventType != null && email != null && !email.isBlank()) {
            final UserEventHandler handler = handlers.get(eventType);
            if (handler != null) {
                handler.handle(userEventDTO);
            } else {
                System.out.println("No handler for " + eventType);
            }
        } else {
            System.out.println("Wrong event type or email"
                    + userEventDTO.getEventType() + ", " + userEventDTO.getEmail());
        }
    }
}
