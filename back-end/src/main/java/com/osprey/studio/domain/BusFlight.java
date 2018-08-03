package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bus_flight_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusFlight extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 10, message = "errors.busflight.value.max")
    @Column(name = "flight_number", nullable = false, length = 10,unique = true)
	private String flightNumber;

    @NotNull
    @Size(min = 3, max = 100, message = "errors.busflight.value.max")
    @Column(name = "flight_name", nullable = false, length = 255,unique = true)
	private String flightName;

    @Size(min = 3, max = 100, message = "errors.busflight.value.max")
    @Column(name = "departure", nullable = true, length = 255,unique = false)
	private String departure;

    @Size(min = 3, max = 100, message = "errors.busflight.value.max")
    @Column(name = "arrival", nullable = true, length = 255,unique = false)
	private String arrival;

    @Size(min = 1, max = 100, message = "errors.busflight.value.max")
    @Column(name = "departure_time", nullable = true, length = 255,unique = false)
	private LocalDateTime departureTime;

    @Size(min = 1, max = 100, message = "errors.busflight.value.max")
    @Column(name = "arrival_time", nullable = true, length = 255,unique = false)
	private LocalDateTime arrivalTime;

    @Size(min = 1, max = 100, message = "errors.busflight.value.max")
    @Column(name = "price", nullable = true, length = 10, unique = false)
	private double price;

    @Size(min = 1, max = 100, message = "errors.busflight.value.max")
    @Column(name = "km", nullable = true, length = 10, unique = false)
	private int km;

}