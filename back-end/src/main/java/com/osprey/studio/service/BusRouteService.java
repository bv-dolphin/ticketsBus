package com.osprey.studio.service;

import com.osprey.studio.domain.BusRoute;
import com.osprey.studio.repository.BusRouteRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public class BusRouteService extends AbstractBaseService<BusRoute> {
    private final BusRouteRepository repository;

    public BusRouteService(BusRouteRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<BusRoute, Long> getRepository() {
        return repository;
    }
}
