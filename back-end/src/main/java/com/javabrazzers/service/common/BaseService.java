package com.javabrazzers.service.common;

import com.javabrazzers.domain.BaseEntity;

import java.util.Optional;

public interface BaseService <E extends BaseEntity>{
    Optional<E> getById(Long id);
    boolean exists(long id);
    E create(E entity);
    long count();
    E update(E entity);
    void delete(long id);
    void delete(E entity);
    Iterable<E> getAll(Iterable<Long> ids);
}
