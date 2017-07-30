package com.company.db.dao.generic;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
    T create(T t);

    T read(PK id);

    T update(T t);

    void delete(T t);

    void delete(PK id);

    //    Collection<T> objectsBySimplePaging(Paging paging);
    Long totalCount();
}