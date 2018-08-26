package com.osprey.studio.service;

import com.osprey.studio.domain.entities.City;
import com.osprey.studio.repository.CityRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService extends AbstractBaseService<City> {

    final public CityRepository repository;

    protected BaseRepository<City, Long> getRepository() {
        return repository;
    }

    public CityService(CityRepository repository) {
        this.repository = repository;
    }
    }
