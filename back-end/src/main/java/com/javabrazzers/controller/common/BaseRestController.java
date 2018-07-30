package com.javabrazzers.controller.common;

import com.javabrazzers.domain.BaseEntity;
import org.springframework.http.ResponseEntity;

public interface BaseRestController<E extends BaseEntity> {
    ResponseEntity<E> getById(Long id);
}
