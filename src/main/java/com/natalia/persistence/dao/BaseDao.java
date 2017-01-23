package com.natalia.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao <T, ID extends Serializable> {

    void save(T element);

    T update(T element);

    void delete(T element);

    T findOne(ID id);

    List<T> findAll();
}
