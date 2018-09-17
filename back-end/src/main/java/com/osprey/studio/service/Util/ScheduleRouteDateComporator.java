package com.osprey.studio.service.Util;

import com.osprey.studio.domain.entities.Schedule;

import java.time.LocalDateTime;
import java.util.Comparator;


/**
 * Компоратор для сравнивания рейсов по дате+время
 */
public class ScheduleRouteDateComporator implements Comparator<Schedule> {
    @Override
    public int compare(Schedule a, Schedule b) {
        LocalDateTime localDateTimeA = LocalDateTime.of(b.getDepartureDate(),b.getBusRoute().getArrivalTime());
        LocalDateTime localDateTimeB = LocalDateTime.of(b.getDepartureDate(),b.getBusRoute().getArrivalTime());
       int compare =localDateTimeA.compareTo(localDateTimeB);
        return compare;
    }
}
