package ru.aston.handler;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.aston.dto.UserEventDTO;
import ru.aston.handler.UserEventType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
public class HandlerConfig {

    @Bean
    public Map<UserEventType, UserEventHandler> handlers(List<UserEventHandler> handlers) {
        Map<UserEventType, UserEventHandler> handlerMap = new EnumMap<>(UserEventType.class);

        for(UserEventHandler handler : handlers) {
            handlerMap.put(handler.getEventType(), handler);
        }
        return handlerMap;
    }
}
