package ru.aston.service;

import ru.aston.dao.UserDAOImpl;
import ru.aston.entity.User;

public class UserService {

    private final UserDAOImpl userDAOImpl = new UserDAOImpl();

    public UserService() {
    }

    public User getUser(long id) {
        return userDAOImpl.get(id);
    }

    public void add(User user) {
        userDAOImpl.add(user);
    }

    public void update(User user) {
        userDAOImpl.update(user);
    }

    public void delete(long id) {
        userDAOImpl.delete(id);
    }
}



