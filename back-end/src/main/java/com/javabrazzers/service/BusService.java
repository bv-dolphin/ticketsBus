package com.javabrazzers.service;

import com.javabrazzers.domain.Bus;
import com.javabrazzers.repository.BusRepository;
import com.javabrazzers.repository.common.BaseRepository;
import com.javabrazzers.service.common.AbstractBaseService;
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
