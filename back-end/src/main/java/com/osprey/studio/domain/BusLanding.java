package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "bus_landing_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusLanding extends BaseEntity {

	@NotNull
	@Size(min = 3, max = 100, message = "errors.buslanding.value.max")
	@Column(name = "place_number", nullable = false, length = 255,unique = true)
	private int placeNumber;
	@Size(min = 3, max = 100, message = "errors.buslanding.value.max")
	@Column(name = "schedule_id", nullable = false, length = 255,unique = true)
	private Schedule schedule;
	@OneToOne
	@JoinColumn(name = "ticket_id")
	private int ticket;

}