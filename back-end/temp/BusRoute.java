package com.javabrazzers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "bus_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusRoute extends BaseEntity {

	private LocalDateTime depatureTime;
	private LocalDateTime arrivalTime;
	private Integer km;
	private BusFlight busFlight;
	private BusStation busStatiom;

}