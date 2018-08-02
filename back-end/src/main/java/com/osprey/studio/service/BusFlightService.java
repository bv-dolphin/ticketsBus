package com.osprey.studio.service;

import com.osprey.studio.domain.BusFlight;
import com.osprey.studio.repository.BusFlightRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public class BusFlightService extends AbstractBaseService<BusFlight> {
    public final BusFlightRepository repository;
    @Override
    protected BaseRepository<BusFlight, Long> getRepository() {
        return repository;
    }

    public BusFlightService(BusFlightRepository repository) {
        this.repository = repository;
    }
}
