package ru.aston.dao;

import ru.aston.entity.User;

public interface UserDAO extends CommonDAO<User>, FindAllDAO<User> {
    User getByEmail(String email);
}
