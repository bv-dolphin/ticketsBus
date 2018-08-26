package com.osprey.studio.domain.entities;

import com.osprey.studio.service.converter.LocalDateTimeConverter;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "bus_flight_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusFlight extends BaseEntity {

    @NotNull
    @Column(name = "flight_number", nullable = false)
	private Integer flightNumber;

    @NotNull
    @Size(min = 3, max = 100, message = "errors.busflight.flightname.value.size")
    @Column(name = "flight_name", nullable = false, length = 255,unique = true)
	private String flightName;

    @Size(min = 3, max = 100, message = "errors.busflight.departure.value.size")
    @Column(name = "departure", nullable = true, length = 100,unique = false)
	private String departure;

    @Size(min = 3, max = 100, message = "errors.busflight.arrival.value.size")
    @Column(name = "arrival", nullable = true, length = 100,unique = false)
	private String arrival;


    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "departure_time", nullable = true)
	private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = true)
	private LocalDateTime arrivalTime;

    @Column(name = "price", nullable = true)
	private double price;

    @Column(name = "km", nullable = true)
	private int km;

}