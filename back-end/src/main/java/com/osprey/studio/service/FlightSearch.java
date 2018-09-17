package com.osprey.studio.service;

import com.osprey.studio.domain.entities.BusFlight;
import com.osprey.studio.domain.entities.BusRoute;
import com.osprey.studio.domain.entities.Schedule;
import com.osprey.studio.repository.BusFlightRepository;
import com.osprey.studio.repository.ScheduleRepositories;
import com.osprey.studio.service.Util.ScheduleRouteDateComporator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class FlightSearch {
    @Autowired
    private BusFlightRepository busFlightRepository;
    @Autowired
    private ScheduleRepositories scheduleRepositories;

    /**
     * Поиск автобусных рейсов
     */
    public List<SortedSet<Schedule>> getScheduleDateRouteSearch(LocalDate date, Long idStantionFirst, Long idStantionTho) {
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList = getScheduleBDonData(date, idStantionFirst, idStantionTho);
        List<SortedSet<Schedule>> flightUser = getFlightUser(scheduleList);
        return flightUser;
    }

    /**
     * Вытягивает с бд по дате, станции откуда, станции куда. Убирает слиста если у станции откуда и куда не 1 рейс.
     */
    public List<Schedule> getScheduleBDonData(LocalDate date, Long idStantionFirst, Long idStantionTho) {
        List<Schedule> scheduleList = new ArrayList<>();
        List<Schedule> scheduleListTho = new ArrayList<>();
        scheduleList = scheduleRepositories.findByDataSearchRout(date, idStantionFirst, idStantionTho);
        for (int i = 0; i < scheduleList.size(); i++) {
            BusRoute busRouteConst = scheduleList.get(i).getBusRoute();
            for (int j = 0; j < scheduleList.size(); j++) {
                boolean compareStantion = scheduleList.get(j).getBusRoute().getBusStation().getId() == busRouteConst.getBusStation().getId();
                boolean compareFlight = scheduleList.get(j).getBusRoute().getBusFlight().getId() == busRouteConst.getBusFlight().getId();
                boolean compareList = false;
                if (scheduleListTho != null) {
                    if (scheduleListTho.contains(scheduleList.get(j))) {
                        compareList = true;
                    }
                }
                if (!compareStantion && compareFlight && !compareList) {
                    scheduleListTho.add(scheduleList.get(j));
                }
            }
        }
        return scheduleListTho;
    }

    /**
     * Из листов рейсов которые вытянули с бд по дате и станциям, вычисляет какой рейс, сортирует по времени отправления маршруты для каждого рейса     *
     */
    public List<SortedSet<Schedule>> getFlightUser(List<Schedule> scheduleList) {

        Set<BusFlight> busFlightsSet = new HashSet<>();
        List<SortedSet<Schedule>> sortedSetsList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            busFlightsSet.add(schedule.getBusRoute().getBusFlight());
        }
        for (BusFlight busFlight : busFlightsSet) {
            List<Schedule> schedule = scheduleRepositories.findByBusRoute_BusFlight_Id(busFlight.getId());
            //нужно проверить если несколько рейсов не будет ли стирать прошлый, если да то подумать как переделать
            SortedSet<Schedule> scheduleSortedSet = new TreeSet<Schedule>(new ScheduleRouteDateComporator());
            scheduleSortedSet.addAll(schedule);
            sortedSetsList.add(scheduleSortedSet);
        }
        return sortedSetsList;
    }
}
