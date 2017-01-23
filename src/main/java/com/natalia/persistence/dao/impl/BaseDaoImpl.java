package com.natalia.persistence.dao.impl;

import com.natalia.persistence.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz;

    public BaseDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(T element) {
        em.persist(element);
    }
    @Override
    public T update(T element) {
        return em.merge(element);
    }
    @Override
    public void delete(T element) {
        em.remove(element);
    }
    @Override
    public T findOne(ID id) {
        return em.find(this.clazz, id);
    }
    @Override
    public List<T> findAll() {
        return em.createQuery("From " + clazz.getSimpleName(), clazz).getResultList();
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}
