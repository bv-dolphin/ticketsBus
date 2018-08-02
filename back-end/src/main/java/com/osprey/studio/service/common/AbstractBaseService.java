package com.osprey.studio.service.common;

import com.osprey.studio.domain.BaseEntity;
import com.osprey.studio.repository.common.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class AbstractBaseService<E extends BaseEntity> implements BaseService<E> {
        //получение название типа класса и записываем в строку
    protected final String entityName = ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();

    protected abstract BaseRepository<E, Long> getRepository();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public boolean exists(Long id) {
        if(id != null){
            return true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        checkArgument(id != null, "can not delete!");
        getRepository().deleteById(id);
    }

    @Override
    public E create(E entity) {

        logger.info("start create");

        // Ensure the entity object to be created does NOT exist in the repository.
        if (entity.getId() != null) {
            // Cannot create Entity with specified ID value
            logger.error("Attempted to create a Entity, id is not null, so, this entity exist.");
            throw new EntityExistsException("The id attribute must be null to persist a new entity.");
        }

        E savedObj = getRepository().save(entity);

        logger.info(" create");

        return savedObj;

    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public E update(E entity) {

        logger.info("update id:", entity.getId());

        if(entity == null) {
            logger.error("Entity can not be null.");
            throw new NoResultException("Requested entity not found.");
        }
        if(entity.getId() == null) {
            logger.error("ID can not be null.");
            throw new NoResultException("Requested entity not found.");
        }

        logger.info("update id:", entity.getId());

        return getRepository().save(entity);

    }


    @Override
    public void delete(E entity) {

        checkArgument(entity != null, "cannot delete!");
        getRepository().delete(entity);

    }

    @Override
    public Iterable<E> getAll(Iterable<Long> ids) {

        logger.info("findAll ");
        Iterable<E> all = getRepository().findAllById(ids);
        if(all == null) logger.info("Empty List");
        logger.info(" findAll");
        return all;

    }
}
