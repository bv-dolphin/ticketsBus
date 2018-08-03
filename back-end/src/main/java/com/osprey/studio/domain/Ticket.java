package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntity {
	@NotNull
	@Column(name = "purchase_date", nullable = false, length = 255,unique = true)
	private LocalDateTime purchaseDate;

	@NotNull
	@Size(min = 3, max = 100, message = "errors.ticket.ticketnumber.value.size")
	@Column(name = "ticket_number", nullable = false, length = 255,unique = true)

	private int ticketNumber;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User User;

}