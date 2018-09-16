package com.osprey.studio.service;

import com.osprey.studio.domain.entities.Schedule;
import com.osprey.studio.repository.ScheduleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightSearch {
    @Autowired
   private ScheduleRepositories scheduleRepositories;



}
