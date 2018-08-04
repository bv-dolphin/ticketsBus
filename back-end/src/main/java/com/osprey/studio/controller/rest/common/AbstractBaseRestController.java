package com.osprey.studio.controller.rest.common;

import com.osprey.studio.domain.BaseEntity;
import com.osprey.studio.service.common.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractBaseRestController<E extends BaseEntity> implements BaseRestController<E> {

    protected abstract BaseService<E> getService();

    @Override
    public ResponseEntity<E> getById(Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        E result = getService().getById(id).get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<E> create(E entity) {
        return null;
    }

    @Override
    public ResponseEntity<E> update(E entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(E entity) {

    }

    @Override
    public ResponseEntity<List<E>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<E>> getAll(Iterable<Long> ids) {
        return null;
    }
}
