package ru.aston.handler;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserEventType {
    @JsonProperty("CreateUser")
    CREATE_USER,
    @JsonProperty("DeleteUser")
    DELETE_USER
}
