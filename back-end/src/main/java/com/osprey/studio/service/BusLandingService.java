package com.osprey.studio.service;

import com.osprey.studio.domain.BusLanding;
import com.osprey.studio.repository.BusLandingRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;

public class BusLandingService extends AbstractBaseService<BusLanding> {
    private final BusLandingRepository repository;

    public BusLandingService(BusLandingRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<BusLanding, Long> getRepository() {
        return repository;
    }
}
