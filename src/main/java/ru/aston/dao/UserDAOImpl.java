package ru.aston.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.aston.HibernateConfiguration;
import ru.aston.entity.User;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void add(User obj) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User get(long id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        return session.find(User.class, id);
    }

    @Override
    public void update(User obj) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getByEmail(String email) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.close();
        return user;

    }

    @Override
    public List<User> findAll() {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<User> findAll(String email) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where email like :email", User.class);
        query.setParameter("email", "%"+email+"%");
        List<User> list = query.getResultList();
        session.close();
        return list;
    }

}
