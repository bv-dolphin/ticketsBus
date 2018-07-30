package com.javabrazzers.controller.common;

import com.javabrazzers.domain.BaseEntity;
import com.javabrazzers.service.common.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
