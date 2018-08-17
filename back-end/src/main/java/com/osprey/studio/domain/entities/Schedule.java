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
@Table(name = "schedule_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseEntity {

	@NotNull
	@Column(name = "depature_date", nullable = false)
	private LocalDateTime departureDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bus_route_id")
	private BusRoute busRoute;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bus_id")
	private Bus bus;

}