package ru.aston.dao;

import java.util.Optional;

public interface CommonDAO <T> {

        Optional<T> find(long id);

        void merge(T obj);

        void remove(T obj);

        void persist(T obj);

}
