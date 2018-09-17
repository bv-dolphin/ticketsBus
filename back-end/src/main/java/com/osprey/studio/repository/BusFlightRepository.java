package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.BusFlight;

import com.osprey.studio.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface BusFlightRepository extends BaseRepository<BusFlight, Long> {

    List<BusFlight> findByDepartureAndArrivalAndDepartureTime(String departure, String arrival, LocalDateTime departureTime);
    List<BusFlight> findByDepartureAndArrivalAndDepartureTimeBetween(String departure, String arrival, LocalDateTime dateone, LocalDateTime datetwo);
    List<BusFlight> findAllById(Long idFlights);
}
