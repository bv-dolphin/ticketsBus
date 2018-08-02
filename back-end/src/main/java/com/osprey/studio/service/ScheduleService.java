package com.osprey.studio.service;

import com.osprey.studio.domain.Schedule;
import com.osprey.studio.repository.ScheduleRepositories;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends AbstractBaseService<Schedule> {
    private final ScheduleRepositories repositories;

    public ScheduleService(ScheduleRepositories repositories) {
        this.repositories = repositories;
    }

    @Override
    protected BaseRepository<Schedule, Long> getRepository() {
        return repositories;
    }
}
