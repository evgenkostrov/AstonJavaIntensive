package ru.aston.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventType;
import ru.aston.handler.UserEventHandler;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class NotificationController {
    private final Map<UserEventType, UserEventHandler> handlers;

    @PostMapping
    public ResponseEntity<?> sendNotification(@Valid @RequestBody UserEventDTO userEventDTO) {
        UserEventHandler handler = handlers.get(userEventDTO.getEventType());
        if (handler == null) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "Invalid event type",
                            "eventType", userEventDTO.getEventType().name()
                    )
            );
        }

        handler.handle(userEventDTO);
        return ResponseEntity.ok().build();
    }
}
