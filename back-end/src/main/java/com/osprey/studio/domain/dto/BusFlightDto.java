package com.osprey.studio.domain.dto;


import com.osprey.studio.domain.entities.BusFlight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class BusFlightDto {

    private Integer flightNumber;
    private String flightName;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;


    public static BusFlightDto from(BusFlight busFlight) {
        return BusFlightDto.builder()
                .flightNumber(busFlight.getFlightNumber())
                .flightName(busFlight.getFlightName())
                .departure(busFlight.getDeparture())
                .departure(busFlight.getDepartureTime().toString())
                .build();
    }

    public static List<BusFlightDto> from(List<BusFlight> flights) {
        return flights.stream().map(BusFlightDto::from).collect(Collectors.toList());
    }




}
