package ru.aston;

import lombok.extern.log4j.Log4j2;
import ru.aston.entity.User;
import ru.aston.service.UserService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

// download IDEA Ultimate (30 days)  for database visible on!
@Log4j2
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final UserConsoleScanner menuManager = new UserConsoleScanner(scanner, userService);

    public static void main(String[] args) throws SQLException {


//        User user = new User(1L,"z","@",5, LocalDateTime.now());
//        UserService userService = new UserService();
//        userService.add(user);
        menuManager.run();
        HibernateConfiguration.close();

    }
}