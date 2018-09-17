package com.osprey.studio;

import com.osprey.studio.controller.ui.MainController;
import com.osprey.studio.domain.entities.Schedule;
import com.osprey.studio.repository.ScheduleRepositories;
import com.osprey.studio.service.FlightSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlightsSearchTest {
    @Autowired
    private MainController controller;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private FlightSearch flightSearch;
    @Autowired
    private ScheduleRepositories scheduleRepositories;

    @Test
    public void listScheduleTest() throws Exception{
        LocalDate localDate= LocalDate.of(2018, 9, 20);
        List<SortedSet<Schedule>> sortedSets = flightSearch.getScheduleDateRouteSearch(localDate, 1L, 2L);
        if (sortedSets!=null) {
            System.out.println(sortedSets.size());
            for (SortedSet<Schedule> listSetov : sortedSets) {
                System.out.println(" TEST!!!!:");
                System.out.println(listSetov.size());
                for (Schedule schedule : listSetov){
                    System.out.println(schedule.getBusRoute().toString());
                }
            }
        }else System.out.println("List = null");
    }

    @Test
    public void testRepository() throws  Exception{
        List<Schedule> scheduleList = scheduleRepositories.findByBusRoute_BusFlight_Id(1L);
        if (scheduleList!=null) {
            for (Schedule schedule : scheduleList) {
                System.out.println(" TEST!!!!:");
                System.out.println(schedule.getBusRoute().toString());
            }
        }
    }
}
