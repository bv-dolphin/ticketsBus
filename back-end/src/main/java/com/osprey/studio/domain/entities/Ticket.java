package com.osprey.studio.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "tickets_tbl",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "ticket_number", name = "ticket_number_unique")})
public class Ticket extends BaseEntity {

	public static final boolean BUN_NULL = false;

	@NotNull(message = "errors.tickets.purchase-date.not-null")
	@Column(name = "purchase_date", nullable = BUN_NULL)
	private LocalDateTime purchaseDate;

	@Size(min = 3, max = 100, message = "errors.tickets.ticketnumber.value.size")
	@Column(name = "ticket_number", nullable = BUN_NULL)
	private Integer ticketNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "ticket_user_fk"))
	private User User;

}
