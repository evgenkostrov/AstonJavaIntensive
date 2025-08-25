package ru.aston.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.aston.handler.UserEventType;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserEventDTO {

    @NotNull
    private UserEventType eventType;

    @NotBlank
    @Email
    private String email;
}

