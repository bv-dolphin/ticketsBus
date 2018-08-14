package com.osprey.studio.service;

import com.osprey.studio.domain.entities.Bus;
import com.osprey.studio.repository.BusRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public  class BusService extends AbstractBaseService<Bus> {
    public final BusRepository repository;
    @Override
    protected BaseRepository<Bus, Long> getRepository() {
        return repository;
    }

    public BusService(BusRepository repository) {
        this.repository = repository;
    }
}
