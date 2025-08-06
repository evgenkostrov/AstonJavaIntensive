package ru.aston.dao;

import java.util.List;

public interface FindAllDAO <T> {

    List<T> findAll();//получить все значения

}
