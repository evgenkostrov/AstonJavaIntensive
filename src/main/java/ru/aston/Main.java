package ru.aston;

import lombok.extern.log4j.Log4j2;
import ru.aston.entity.User;
import ru.aston.service.UserService;

import java.sql.SQLException;
import java.time.LocalDateTime;

// download IDEA Ultimate (30 days)  for database visible on!
@Log4j2
public class Main {
    public static void main(String[] args) throws SQLException {

        User user = new User(1L,"z","@",5, LocalDateTime.now());
        UserService userService = new UserService();
        userService.add(user);

    }
}