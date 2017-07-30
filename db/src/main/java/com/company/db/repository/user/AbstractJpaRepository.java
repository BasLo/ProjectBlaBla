package com.company.db.repository.user;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaRepository<T, ID extends Serializable>
        implements JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    protected Class<T> entityClass;

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Iterable<ID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void delete(Iterable<? extends T> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends T> S save(S s) {
        return null;
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public T findOne(ID id) {
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public T getOne(ID id) {
        return null;
    }

    @Override
    public <S extends T> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public T findOne(Specification<T> specification) {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> specification) {
        return null;
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<T> specification) {
        return 0;
    }
}
