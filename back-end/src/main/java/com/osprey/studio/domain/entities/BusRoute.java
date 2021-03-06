package com.osprey.studio.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "bus_route_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusRoute extends BaseEntity {

    @NotNull
    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @NotNull
    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @NotNull
    @Column(name = "km", nullable = true)
	private Integer km;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_flight_id")
	private BusFlight busFlight;

	@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_station_id")
	private BusStation busStation;

}