package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "bus_route_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusRoute extends BaseEntity {

    @Column(name = "departure_time", nullable = false, length = 7, unique = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false, length = 7, unique = false)
    private LocalDateTime arrivalTime;

    @Size(min = 1, max = 100, message = "errors.busroute.km.max")
    @Column(name = "km", nullable = true, length = 10, unique = false)
	private Integer km;


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_flight_id")
	private BusFlight busFlight;
	@ManyToOne
    @JoinColumn(name = "bus_station_id")
	private BusStation busStation;

}