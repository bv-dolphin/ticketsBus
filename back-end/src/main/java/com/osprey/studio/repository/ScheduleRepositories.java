package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.Schedule;
import com.osprey.studio.repository.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepositories extends BaseRepository<Schedule, Long> {
    @Query(value = "SELECT * FROM schedule_tbl inner join bus_route_tbl on schedule_tbl.bus_route_id = bus_route_tbl.id WHERE depature_date= ? and (((bus_route_tbl.bus_station_id) = ?) or ((bus_route_tbl.bus_station_id) = ?))", nativeQuery = true)
    List<Schedule> findByDataSearchRout(LocalDate date, Long idStantionFirst, Long idStantionTho);
}
