package com.osprey.studio.service;

import com.osprey.studio.domain.Region;
import com.osprey.studio.repository.RegionRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;

public class RegionService extends AbstractBaseService<Region> {

    public final RegionRepository repository;

    protected BaseRepository<Region, Long> getRepository() {
        return repository;
    }

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }
}
