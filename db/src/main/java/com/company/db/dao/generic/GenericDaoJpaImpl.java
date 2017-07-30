package com.company.db.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDaoJpaImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager em;

    public GenericDaoJpaImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityClass = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.em.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.em.merge(t);
    }

    @Override
    public void delete(T t) {
//        t = this.em.merge(t);
        this.em.remove(t);
    }

    @Override
    public void delete(PK id) {
        T t = read(id);
        delete(t);
    }

    @Override
    public Long totalCount() {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(this.entityClass)));
        return this.em.createQuery(countQuery).getSingleResult();
    }

}
