package com.javabrazzers.service.common;

import com.javabrazzers.domain.BaseEntity;
import com.javabrazzers.repository.common.BaseRepository;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.Locale;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class AbstractBaseService <E extends BaseEntity> implements BaseService<E>{
        //получение название типа класса и записываем в строку
    protected final String entityName = ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();

    protected abstract BaseRepository<E, Long> getRepository();

    @Override
    public Optional<E> getById(Long id) {
        checkArgument(id != null, "Received incoming parameter null!");  //гугл ультилита- проверка на null
        Optional<E> entity = getRepository().findById(id);
        if (!entity.isPresent()) {
            throw new EntityNotFoundException(entityName.getClass() + "  nety  takogo");
        }
        return entity;
    }

    @Override
    public boolean exists(long id) {
        return false;
    }

    @Override
    public E create(E entity) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public E update(E entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(E entity) {

    }

    @Override
    public Iterable<E> getAll(Iterable<Long> ids) {
        return null;
    }
}
