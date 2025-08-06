package ru.aston.dao;

import ru.aston.entity.User;

import java.util.Optional;

public interface UserDAO extends CommonDAO<User>, FindAllDAO<User> {

}
