package com.osprey.studio.service;

import com.osprey.studio.domain.BusStation;
import com.osprey.studio.repository.BusStationRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;

public class BusStationService extends AbstractBaseService<BusStation> {

    final public BusStationRepository repository;

    protected BaseRepository<BusStation, Long> getRepository() {
        return repository;
    }

    public BusStationService(BusStationRepository repository) {
        this.repository = repository;
    }
}
