package com.osprey.studio.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "bus_landing_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusLanding extends BaseEntity {

	@NotNull
	@Column(name = "place_number", nullable = false)
	private Integer placeNumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

}