package com.osprey.studio.service;

import com.osprey.studio.domain.entities.BusRoute;
import com.osprey.studio.domain.entities.Schedule;
import com.osprey.studio.repository.ScheduleRepositories;
import com.osprey.studio.service.Util.ScheduleRouteDateComporator;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class FlightSearch {
    @Autowired
    private ScheduleRepositories scheduleRepositories;
    /**
     * Поиск автобусных рейсов
     */
    public List<Schedule> getScheduleDateRouteSearch(LocalDate date, Long idStantionFirst, Long idStantionTho) {
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList = getScheduleBDonData(date, idStantionFirst, idStantionTho);
        return scheduleList;
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
                if (scheduleListTho != null) { //TODO зачем проверка? если на 34 строчке существует объект
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
     * Из листов рейсов которые вытянули с бд по дате и станциям, вычисляет какой рейс, сортирует по времени отправления маршруты
     * и откидывает лишние маршруты если они раньше или позже тех станций которые ввел пользователь
     */
    public SortedSet<Schedule> getFlightUser(List<Schedule> scheduleList, Long idStantionFirst, Long idStantionTho){
        SortedSet<Schedule> scheduleSortedSet = new TreeSet<Schedule>(new ScheduleRouteDateComporator());
        for (Schedule schedule: scheduleList){

        }


        return scheduleSortedSet;
    }
}
