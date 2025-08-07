package ru.aston.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.aston.HibernateConfigurationUtils;
import ru.aston.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    public UserDAOImpl(EntityManagerFactory emf) {
    }

    @Override
    public void persist(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfigurationUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Ошибка при сохранении пользователя", e);
        }
    }

    @Override
    public Optional<User> find(long id) {
        try (Session session = HibernateConfigurationUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.find(User.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при поиске пользователя по ID: " + id, e);
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateConfigurationUtils.getSessionFactory().openSession()) {
            CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
            cq.from(User.class);
            return session.createQuery(cq).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при получении списка пользователей", e);
        }
    }

    @Override
    public void merge(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfigurationUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Ошибка при обновлении пользователя", e);
        }
    }

    @Override
    public void remove(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfigurationUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Ошибка при удалении пользователя", e);
        }
    }
}
