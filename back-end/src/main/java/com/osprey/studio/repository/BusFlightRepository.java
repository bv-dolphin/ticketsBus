package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.BusFlight;

import com.osprey.studio.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface BusFlightRepository extends BaseRepository<BusFlight, Long> {

    List<BusFlight> findByDepartureAndArrival(String departure, String arrival);
}
