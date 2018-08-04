package com.osprey.studio.controller.rest.common;

import com.osprey.studio.domain.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseRestController<E extends BaseEntity> {

    ResponseEntity<E> getById(Long id);

    ResponseEntity<E> create(E entity);

    ResponseEntity<E> update(E entity);

    void delete(Long id);

    void delete(E entity);

    ResponseEntity<List<E>> getAll();

    ResponseEntity<List<E>> getAll(Iterable<Long> ids);



}
