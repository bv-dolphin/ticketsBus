package com.osprey.studio.controller.common;

import com.osprey.studio.domain.BaseEntity;
import org.springframework.http.ResponseEntity;

public interface BaseRestController<E extends BaseEntity> {
    ResponseEntity<E> getById(Long id);
}
