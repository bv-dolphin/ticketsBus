package com.osprey.studio.service;

import com.osprey.studio.domain.entities.BusFlight;
import com.osprey.studio.repository.BusFlightRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

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

    public List<BusFlight> search(String departure, String arrival, LocalDateTime departureTime) {
        LocalDateTime departureTimeTho = departureTime.plusDays(1);

        return repository.findByDepartureAndArrivalAndDepartureTimeBetween(departure, arrival, departureTime, departureTimeTho);
    }


}