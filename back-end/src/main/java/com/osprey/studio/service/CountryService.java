package com.osprey.studio.service;

import com.osprey.studio.domain.Country;
import com.osprey.studio.repository.CountryRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;

public class CountryService extends AbstractBaseService<Country> {
public final CountryRepository repository;
@Override
protected BaseRepository<Country, Long> getRepository() {
        return repository;
        }

public CountryService(CountryRepository repository) {
        this.repository = repository;
        }
        }
