package com.osprey.studio;

import com.osprey.studio.controller.ui.MainController;
import com.osprey.studio.domain.entities.Schedule;
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

    @Test
    public void listScheduleTest() throws Exception{
        LocalDate localDate= LocalDate.of(2018, 9, 20);
        List<Schedule> scheduleList= flightSearch.getScheduleDateRouteSearch(localDate, 1L, 2L);
        if (scheduleList!=null) {
            for (Schedule schedule : scheduleList) {
                System.out.println(" TEST!!!!:");
                System.out.println(scheduleList.size());
                System.out.println(schedule.getBusRoute().toString());
            }
        }
    }
}
