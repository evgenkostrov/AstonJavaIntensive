package ru.aston.service;

import ru.aston.dao.UserDAOImpl;
import ru.aston.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDAOImpl userDAOImpl = new UserDAOImpl();

    public void persistUser(User user) {
        validateUser(user);
        userDAOImpl.persist(user);
    }

    public Optional<User> findUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Некорректный ID пользователя");
        }
        return userDAOImpl.find(id);
    }

    public List<User> findAllUsers() {
        List<User> users = userDAOImpl.findAll();
        if (users.isEmpty()) {
            System.out.println("В системе пока нет пользователей");
        }
        return users;
    }

    public void mergeUser(User user) {
        validateUser(user);
        if (userNotExist(user.getId())) {
            throw new IllegalArgumentException("Пользователь с ID " + user.getId() + " не найден");
        }
        userDAOImpl.merge(user);
    }

    public void removeUser(User user) {
        if (userNotExist(user.getId())) {
            throw new IllegalArgumentException("Пользователь с ID " + user.getId() + " не найден");
        }
        userDAOImpl.remove(user);
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не может быть null");
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя обязательно");
        }
    }

    private boolean userNotExist(Long id) {
        return id == null || userDAOImpl.find(id).isEmpty();
    }
}



