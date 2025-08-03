package ru.aston.dao;

import java.util.List;

public interface FindAllDAO <T> {

    List<T> findAll();//получить все значения

    List<T> findAll(String email);//получить все значения по емайл

}
